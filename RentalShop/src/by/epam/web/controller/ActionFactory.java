package by.epam.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import by.epam.web.controller.action.*;

public class ActionFactory {
	private static final ActionFactory factory = new ActionFactory();
	private final Map<ActionName, Action> repository = new HashMap<ActionName, Action>();
	
	/*DELETE_USER, GET_ALL_USERS, REGISTER, SIGN_IN, SIGN_OUT, ADD_EQUIPMENT, DELETE_EQUIPMENT_BY_ID,
	GET_ALL_EQUIPMENT, CLOSE_ORDER, CREATE_ORDER, OPEN_ORDER, WRONG_REQUEST;*/
	private ActionFactory(){
		repository.put(ActionName.DELETE_USER, new DeleteUser());
		repository.put(ActionName.GET_ALL_USERS, new GetAllUsersAction());
		repository.put(ActionName.REGISTER, new RegisterAction());
		repository.put(ActionName.SIGN_IN, new SignInAction());
		repository.put(ActionName.SIGN_OUT, new SignOutAction());
		repository.put(ActionName.ADD_EQUIPMENT, new AddEquipmentAction());
		repository.put(ActionName.DELETE_EQUIPMENT_BY_ID, new DeleteItemByIdAction());
		repository.put(ActionName.GET_ALL_EQUIPMENT, new GetAllEquipmentAction());
		repository.put(ActionName.ADD_TO_CART, new AddToCartAction());
		repository.put(ActionName.UPDATE_CART, new UpdateCartAction());
		repository.put(ActionName.DELETE_FROM_CART, new DeleteFromCartAction());
		repository.put(ActionName.ADD_CART, new AddCartAction());
		repository.put(ActionName.GET_USER_ITEMS, new GetItemsByUserIdAction());
		repository.put(ActionName.DELETE_ITEM_BY_ID, new DeleteItemByIdAction());
		repository.put(ActionName.SET_EN, new SetENAction());
		repository.put(ActionName.SET_RU, new SetRUAction());
	}
	
	public static ActionFactory getInstance(){
		return factory;
	}
	
	public Action getAction(String action){
		ActionName actionName = ActionName.valueOf(action);
		Action act = repository.get(actionName);
		return act;
	}
}
