package br.edu.claudivan.springconectado.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends BaseEntity {

    private String content;
    @ManyToOne
    private User user;
    @ManyToOne
    private Article article;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
