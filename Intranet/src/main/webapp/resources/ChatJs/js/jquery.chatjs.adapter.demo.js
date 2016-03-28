/// <reference path="jquery.chatjs.adapter.ts" />
var DemoAdapterConstants = (function () {
    function DemoAdapterConstants() {
    }
    DemoAdapterConstants.CURRENT_USER_ID = 1;
     
    DemoAdapterConstants.ECHOBOT_USER_ID = 2;

    DemoAdapterConstants.DEFAULT_ROOM_ID = 1;

    DemoAdapterConstants.ECHOBOT_TYPING_DELAY = 1000;

    DemoAdapterConstants.ECHOBOT_REPLY_DELAY = 3000;
    return DemoAdapterConstants;
})();

var DemoClientAdapter = (function () {
    function DemoClientAdapter() {
        this.messagesChangedHandlers = [];
        this.typingSignalReceivedHandlers = [];
        this.userListChangedHandlers = [];
    }
    // adds a handler to the messagesChanged event
    DemoClientAdapter.prototype.onMessagesChanged = function (handler) {
        this.messagesChangedHandlers.push(handler);
    };

    // adds a handler to the typingSignalReceived event
    DemoClientAdapter.prototype.onTypingSignalReceived = function (handler) {
        this.typingSignalReceivedHandlers.push(handler);
    };

    // adds a handler to the userListChanged event
    DemoClientAdapter.prototype.onUserListChanged = function (handler) {
        this.userListChangedHandlers.push(handler);
    };

    DemoClientAdapter.prototype.triggerMessagesChanged = function (message) {
        for (var i = 0; i < this.messagesChangedHandlers.length; i++)
            this.messagesChangedHandlers[i](message);
    };

    DemoClientAdapter.prototype.triggerTypingSignalReceived = function (typingSignal) {
        for (var i = 0; i < this.typingSignalReceivedHandlers.length; i++)
            this.typingSignalReceivedHandlers[i](typingSignal);
    };

    DemoClientAdapter.prototype.triggerUserListChanged = function (userListChangedInfo) {
        for (var i = 0; i < this.userListChangedHandlers.length; i++)
            this.userListChangedHandlers[i](userListChangedInfo);
    };
    return DemoClientAdapter;
})();

var DemoServerAdapter = (function () {
    function DemoServerAdapter(clientAdapter) {
        this.clientAdapter = clientAdapter;
        
        // configuring users
        var myUser = new ChatUserInfo();
        myUser.Id = DemoAdapterConstants.CURRENT_USER_ID;
       
        var json2=( function  ()  { 
           var json2 =  null ; 
        $.ajax ({
            async :  false , 
             global :  false ,     
            url : '/Intranet/sup/ajaxUsu.json' ,
            dataType :  "json" , 
            success :  function  ( data )  { 
             json2 = data ; 
         } 
        });

       return json2 ; 
       })();
        myUser.RoomId = json2.nif;
        myUser.Name = json2.nombre;
        myUser.Email = json2.email;
        myUser.ProfilePictureUrl = "/Intranet/resources/fotosPerfil/"+json2.nombrefotografia;
        myUser.Status = json2.inicioS /* Online */;
        
        this.users = new Array();
        this.users.push(myUser);
        var l=0;
       var json=( function  ()  { 
           var json =  null ; 
       $.ajax ({
           async :  false , 
            global :  false ,     
           url : '/Intranet/sup/ajaxContactos.json' ,
           dataType :  "json" , 
           success :  function  ( data )  { 
            json = data ; 
        } 
       });
       
      return json ; 
      })(); 
       for(var i=0; i<json.length; i++) 
            {
                 var echoBotUser = new ChatUserInfo();
                echoBotUser.Id = DemoAdapterConstants.ECHOBOT_USER_ID+""+(i+1);
                echoBotUser.RoomId = json[i]['nif'];
                echoBotUser.Name = json[i]['nombre'];
                echoBotUser.Email = json[i]['email'];
                echoBotUser.ProfilePictureUrl = "/Intranet/resources/fotosPerfil/"+json[i]['nombrefotografia'];
                echoBotUser.Status = json[i]['inicioS'] /* Online */;
                this.users.push(echoBotUser);
            }
       
        // adds the users in the global user list
        
        
        // configuring rooms
        var defaultRoom = new ChatRoomInfo();
        defaultRoom.Id = 1;
        defaultRoom.Name = "Default Room";
        defaultRoom.UsersOnline = this.users.length;

        this.rooms = new Array();
        this.rooms.push(defaultRoom);

        // configuring client to return every event to me
        this.clientAdapter.onMessagesChanged(function (message) {
            return function () {
            };
        });
    }
    var roomId2;
    DemoServerAdapter.prototype.sendMessage = function (roomId, conversationId, otherUserId, messageText, clientGuid, done) {
        var _this = this;
        
        console.log("DemoServerAdapter: sendMessage");

        // we have to send the current message to the current user first
        // in chatjs, when you send a message to someone, the same message bounces back to the user
        // just so that all browser windows are synchronized
        var bounceMessage = new ChatMessageInfo();
        bounceMessage.UserFromId = DemoAdapterConstants.CURRENT_USER_ID; // It will from our user
        bounceMessage.UserToId = DemoAdapterConstants.ECHOBOT_USER_ID; // ... to the Echobot
        bounceMessage.RoomId = roomId;
        bounceMessage.ConversationId = conversationId;
        bounceMessage.Message = messageText;
        
        bounceMessage.ClientGuid = clientGuid;
        

        setTimeout(function () {
            _this.clientAdapter.triggerMessagesChanged(bounceMessage);
        }, 300);

        // now let's send a message as if it was from the Echobot
        setTimeout(function () {
            _this.getUserInfo(otherUserId, function (echobotUserInfo) {
                var typingSignal = new ChatTypingSignalInfo();
                typingSignal.ConversationId = conversationId;
                typingSignal.RoomId = roomId2;
                typingSignal.UserFrom = echobotUserInfo;
               
                // if it's not a private message, the echo message will be to the current user
                if (!roomId && !conversationId){
                    typingSignal.UserToId = roomId2;
                
                var search={"nifReceptor":roomId2,"asunto":messageText}
               
                    $.ajax({
                        type: "POST",
                        contentType : 'application/json; charset=utf-8',
                        dataType : 'json',
                        url: "/Intranet/sup/ajaxaddMensaje.json",
                        data:JSON.stringify(search), // Adjuntar los campos del formulario enviado.
                        success: function(data)
                        {
                           
                        },error:function(data,status,er) { 
                            
                         }
                      });
                }
                _this.clientAdapter.triggerTypingSignalReceived(typingSignal);

                setTimeout(function () {
                    // if otherUserId is not null, this is a private message
                    // if roomId is not null, this is a message to a room
                    // if conversationId is not null, this is a message to a conversation (group of people talking as if it was a room)
                    var echoMessage = new ChatMessageInfo();
                    echoMessage.UserFromId = DemoAdapterConstants.ECHOBOT_USER_ID; // It will be from Echobot
                    echoMessage.RoomId = roomId;
                    echoMessage.ConversationId = conversationId;
                    echoMessage.Message = "You said: " + messageText;
                    
                    // if it's not a private message, the echo message will be to the current user
                    if (!roomId && !conversationId)
                        echoMessage.UserToId = DemoAdapterConstants.CURRENT_USER_ID;

                    // this will send a message to the user 1 (you) as if it was from user 2 (Echobot)
                    _this.clientAdapter.triggerMessagesChanged(echoMessage);
                }, DemoAdapterConstants.ECHOBOT_REPLY_DELAY);
            });
        }, DemoAdapterConstants.ECHOBOT_TYPING_DELAY);
    };

    DemoServerAdapter.prototype.sendTypingSignal = function (roomId, conversationId, userToId, done) {
        console.log("DemoServerAdapter: sendTypingSignal");
       
    };

    DemoServerAdapter.prototype.getMessageHistory = function (roomId, conversationId, otherUserId, done) {
        console.log("DemoServerAdapter: getMessageHistory");
        done([]);
        
    };

    DemoServerAdapter.prototype.getUserInfo = function (userId, done) {
        console.log("DemoServerAdapter: getUserInfo");
        var user = null;
        for (var i = 0; i < this.users.length; i++) {
            if (this.users[i].Id == userId) {
                user = this.users[i];
                roomId2=this.users[i].RoomId;
                break;
            }
        }
        if (user == null)
            throw "User doesn't exit. User id: " + userId;
        done(user);
        
    };

    DemoServerAdapter.prototype.getUserList = function (roomId, conversationId, done) {
        console.log("DemoServerAdapter: getUserList");
        if (roomId == DemoAdapterConstants.DEFAULT_ROOM_ID) {
            done(this.users);
          
           return;
        }
        
        throw "The given room or conversation is not supported by the demo adapter";
    };

    DemoServerAdapter.prototype.enterRoom = function (roomId, done) {
        console.log("DemoServerAdapter: enterRoom");

        if (roomId != DemoAdapterConstants.DEFAULT_ROOM_ID)
            throw "Only the default room is supported in the demo adapter";

        var userListChangedInfo = new ChatUserListChangedInfo();
        userListChangedInfo.RoomId = DemoAdapterConstants.DEFAULT_ROOM_ID;
        userListChangedInfo.UserList = this.users;
        
        this.clientAdapter.triggerUserListChanged(userListChangedInfo);
    };

    DemoServerAdapter.prototype.leaveRoom = function (roomId, done) {
        
        console.log("DemoServerAdapter: leaveRoom");
    };

    // gets the given user from the user list
    DemoServerAdapter.prototype.getUserById = function (userId) {
        for (var i = 0; i < this.users.length; i++) {
            if (this.users[i].Id == userId){
                return this.users[i];
            }
        }
         alert(""+userId); 
       throw "Could not find the given user";
    };
    return DemoServerAdapter;
})();

var DemoAdapter = (function () {
    function DemoAdapter() {
    }
    // called when the adapter is initialized
    DemoAdapter.prototype.init = function (done) {
        this.client = new DemoClientAdapter();
        this.server = new DemoServerAdapter(this.client);
        done();
    };
    return DemoAdapter;
})();
//# sourceMappingURL=jquery.chatjs.adapter.demo.js.map
