package com.netcracker.rest_service.entity;

import org.glassfish.grizzly.http.util.TimeStamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entity
@Table(name = "message")
public class Message implements Serializable{
    @Id
    @GeneratedValue
    private long id;

    @Column(name =  "body")
    //@NotNull
    private String body;

    @Column(name = "time")
    @NotNull
    private TimeStamp time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public TimeStamp getTime() {
        return time;
    }

    public void setTime(TimeStamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (body != null ? !body.equals(message.body) : message.body != null) return false;
        return time != null ? time.equals(message.time) : message.time == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", time=" + time +
                '}';
    }
}
