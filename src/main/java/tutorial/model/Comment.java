package tutorial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;							
import javax.validation.constraints.NotBlank;
import java.util.Objects;
@Entity
@Table(name = "comments")
public class Comment {
	private @Id @GeneratedValue Long id;
	private  @NotBlank String description;
	private  @NotBlank Long topicId;
	private  @NotBlank Long userId;

	public Comment() {
		
	}
	public Comment(@NotBlank Long topicId, 
	        @NotBlank Long userId) {
		this.topicId = topicId;
		this.userId = userId;
	}
	
	
	
	
}