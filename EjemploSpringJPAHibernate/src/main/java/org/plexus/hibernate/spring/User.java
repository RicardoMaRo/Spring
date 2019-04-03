package org.plexus.hibernate.spring;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
		
		@Id
		private int id;
		
		private String userName;
		
		private String userMessage;
		
		// Constructor
		public User() {
			
		}
		
		//Builder
		 public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserMessage() {
			return userMessage;
		}

		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
}


