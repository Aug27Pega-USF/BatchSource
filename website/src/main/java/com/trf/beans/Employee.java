package com.trf.beans;

public class Employee {

		String user_id, refersto, user_type_id, first_name, last_name, basic_info_placeholder, available_reimbursement, pending_reimbursement, awarded_reimbursement;

		public Employee(String user_id, String refersto, String user_type_id, String first_name, String last_name,
				String basic_info_placeholder, String available_reimbursement, String pending_reimbursement,
				String awarded_reimbursement) {
			super();
			this.user_id = user_id;
			this.refersto = refersto;
			this.user_type_id = user_type_id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.basic_info_placeholder = basic_info_placeholder;
			this.available_reimbursement = available_reimbursement;
			this.pending_reimbursement = pending_reimbursement;
			this.awarded_reimbursement = awarded_reimbursement;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getRefersto() {
			return refersto;
		}

		public void setRefersto(String refersto) {
			this.refersto = refersto;
		}

		public String getUser_type_id() {
			return user_type_id;
		}

		public void setUser_type_id(String user_type_id) {
			this.user_type_id = user_type_id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getBasic_info_placeholder() {
			return basic_info_placeholder;
		}

		public void setBasic_info_placeholder(String basic_info_placeholder) {
			this.basic_info_placeholder = basic_info_placeholder;
		}

		public String getAvailable_reimbursement() {
			return available_reimbursement;
		}

		public void setAvailable_reimbursement(String available_reimbursement) {
			this.available_reimbursement = available_reimbursement;
		}

		public String getPending_reimbursement() {
			return pending_reimbursement;
		}

		public void setPending_reimbursement(String pending_reimbursement) {
			this.pending_reimbursement = pending_reimbursement;
		}

		public String getAwarded_reimbursement() {
			return awarded_reimbursement;
		}

		public void setAwarded_reimbursement(String awarded_reimbursement) {
			this.awarded_reimbursement = awarded_reimbursement;
		}

		@Override
		public String toString() {
			return "Employee [user_id=" + user_id + ", refersto=" + refersto + ", user_type_id=" + user_type_id
					+ ", first_name=" + first_name + ", last_name=" + last_name + ", basic_info_placeholder="
					+ basic_info_placeholder + ", available_reimbursement=" + available_reimbursement
					+ ", pending_reimbursement=" + pending_reimbursement + ", awarded_reimbursement="
					+ awarded_reimbursement + "]";
		}
		
}
