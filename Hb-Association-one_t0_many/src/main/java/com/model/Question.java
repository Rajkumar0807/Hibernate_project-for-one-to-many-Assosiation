package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="question_1")
public class Question {
  @Id  
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  //@PrimaryKeyJoinColumn
  int id;
  String question;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="qid")
  @OrderColumn(name="type")
  private List<Answer> answer;
public int getId() {
	return id;
}
public String getQuestion() {
	return question;
}
public List<Answer> getAnswer() {
	return answer;
}
public void setId(int id) {
	this.id = id;
}
public void setQuestion(String question) {
	this.question = question;
}
public void setAnswer(List<Answer> answer) {
	this.answer = answer;
}
  
  
}
