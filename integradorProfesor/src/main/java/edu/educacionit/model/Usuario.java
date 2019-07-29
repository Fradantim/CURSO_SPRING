package edu.educacionit.model;

public class Usuario {
    private String id;
    private String nombreUsuario;
    private String password;
    private String[] roles;

    public Usuario() {
    }
    
    public Usuario(String id, String nombreUsuario, String password, String[] roles) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
    
    
}
