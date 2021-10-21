package tutorial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;							
import javax.validation.constraints.NotBlank;
//import java.util.Objects;
@Entity
@Table(name = "comments")
public class Comment {
	private @Id @GeneratedValue Long id;
//	private @NotBlank User user;
	private  @NotBlank String description;
	private  @NotBlank Long topicId;
	private  @NotBlank Long userId;
	
	public Comment() {
		
	}
	public Comment(@NotBlank String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}