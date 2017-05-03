package by.epam.web.customtag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.web.bean.Equipment;

public class EquipmentTagHandler extends TagSupport{

	private static final long serialVersionUID = 1L;
	private ArrayList<Equipment> equipmentList;
	
	public int doStartTag() throws JspException{
	
		try{
			JspWriter out = pageContext.getOut();
			out.write("<table><tr><th>ID</th><th>Name</th><th>Price</th><th>Cost</th></tr>");

			for (int i=0; i<equipmentList.size(); i++){
				out.write("<tr>");
				out.write("<th>"+equipmentList.get(i).getId()+"</th>");
				out.write("<th>"+equipmentList.get(i).getName()+"</th>");
				out.write("<th>"+equipmentList.get(i).getPrice()+"</th>");
				out.write("<th>"+equipmentList.get(i).getCost()+"</th>");
				out.write("</tr>");
			}
			out.write("</table>");
			out.write("<form action=\"/RentalShop/RentalShopController\">");
			out.write("Name: <input type=\"hidden\" name=\"action\" value=\"AddEquipment\">");
			out.write("Name: <input type=\"text\" name=\"name\" value=\"\">");
			out.write("Cost: <input type=\"number\" step=\"0.01\" name=\"cost\" value=\"\">");
			out.write("Price: <input type=\"number\" step=\"0.01\" name=\"price\" value=\"\">");
			out.write("<input type=\"submit\" value=\"Add\">");
			out.write("</form>");
		}catch(IOException e){
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
	
	public void setEquipmentList(ArrayList<Equipment> equipmentList){
		this.equipmentList = equipmentList;
	}
	
	public ArrayList<Equipment> getEquipmentList(){
		return equipmentList;
	}

}
