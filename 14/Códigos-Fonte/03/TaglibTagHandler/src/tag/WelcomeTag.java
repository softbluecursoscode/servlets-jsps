package tag;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WelcomeTag extends SimpleTagSupport {
	
	private String usuario;

	@Override
	public void doTag() throws JspException, IOException {
		
		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		String text;
		
		if (hour >= 0 && hour <= 12) {
			text = "Bom dia";
		} else if(hour >= 13 && hour <= 18) {
			text = "Boa tarde";
		} else {
			text = "Boa noite";
		}
		
		getJspContext().getOut().print(text + ", " + usuario);
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
