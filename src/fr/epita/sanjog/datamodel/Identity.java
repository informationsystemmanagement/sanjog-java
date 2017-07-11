/**
 * 
 */
package fr.epita.sanjog.datamodel;

/**
 * @author Admin
 *
 */
public class Identity {
	public String uname;
	public String uemail;
	/**
	 * @param uname
	 * @param uemail
	 */
	public Identity(String uname, String uemail) {
		this.uname = uname;
		this.uemail = uemail;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the uemail
	 */
	public String getUemail() {
		return uemail;
	}
	/**
	 * @param uemail the uemail to set
	 */
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	
	

}
