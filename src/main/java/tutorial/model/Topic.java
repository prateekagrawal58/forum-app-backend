package tutorial.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "topics")
public class Topic {
    private @Id @GeneratedValue Long id;
    private @NotBlank Long userId;
    private @NotBlank String title;
    private @NotBlank String content;
    private @NotBlank Date creationDate;
    private @NotBlank Date lastUpdateDate;
    
    public Topic() {
    }

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
        this.lastUpdateDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }


    @Override
    public int hashCode() {
        final long prime = 31;
        long result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + id;
        result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return (int)result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Topic other = (Topic) obj;
        
        if (content == null) {
            if (other.content != null) {
                return false;
            }
        } else if (!content.equals(other.content)) {
            return false;
        }
        if (creationDate == null) {
            if (other.creationDate != null) {
                return false;
            }
        } else if (!creationDate.equals(other.creationDate)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (lastUpdateDate == null) {
            if (other.lastUpdateDate != null) {
                return false;
            }
        } else if (!lastUpdateDate.equals(other.lastUpdateDate)) {
            return false;
        }

        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        if (userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!userId.equals(other.userId)) {
            return false;
        }
		return false;
    }
}
