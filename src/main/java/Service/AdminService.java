package Service;

import Repository.AdminRepository;
import model.Admin;

public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminService() {
        this.adminRepository = new AdminRepository();
    }

    public Admin login(String fullName, String password) {
        Admin admin = adminRepository.findByFullName(fullName);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
}
