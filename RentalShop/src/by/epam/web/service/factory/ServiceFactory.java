package by.epam.web.service.factory;

import by.epam.web.service.implementation.*;
import by.epam.web.service.interfaces.*;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final AdminService adminService = new AdminServiceImpl();
	private final ClientService clientService = new ClientServiceImpl();
	private final EquipmentService equipmentService = new EquipmentServiceImpl();
	private final ItemService ItemService = new ItemServiceImpl();
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public ClientService getClientService() {
		return clientService;
	}
	public EquipmentService getEquipmentService() {
		return equipmentService;
	}
	public ItemService getItemService() {
		return ItemService;
	}
		
}
