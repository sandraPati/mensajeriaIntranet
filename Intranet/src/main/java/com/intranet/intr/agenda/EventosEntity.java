/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr.agenda;


public class EventosEntity {
    private int id;
    private String title;
	private String start;
	private String end;
	private String url;
	private String className;
	public EventosEntity(){
		
	}	
	
	public EventosEntity(int id,String title, String start,String end, String className) {
		super();
		this.id=id;
                this.title = title;
		this.start = start;
                this.end=end;
                this.className=className;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
        
}
