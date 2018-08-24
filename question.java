
public class question {
 int sid;
 int qid;
 String qstmt;
 String qtype;
 String qoptions;
String qans;
		
		public question() {
			
		}
		
		public question( int sid,int qid,String qstmt,String qtype,String qoptions,String qans)
		{
			this.qid=qid;
			this.sid=sid;
			this.qstmt=qstmt;
			this.qtype=qtype;
			this.qoptions=qoptions;
			this.qans=qans;
		}

		public int getsid() {
			return sid;
		}
		public int getqid() {
			return qid;
		}

		public void setsid(int sid) {
			this.sid = sid;
		}
		public void setqid(int qid) {
			this.qid = qid;
		}

		public String getqstmt() {
			return qstmt;
		}
		

		public void setqstmt(String qstmt) {
			this.qstmt = qstmt;
		}

		public String getqtype() {
			return qtype;
		}
		
		public void setqtype(String qtype) {
			this.qtype = qtype;
		}
		public String getqoptions() {
			return qoptions;
		}
		public void setqoptions(String qoptions) {
			this.qoptions = qoptions;
		}

		public String getqans() {
			return qans;
		}
		public void setqans(String qans) {
			this.qans = qans;
		}
		
			
		
		
	}
