package gfraisse.ImposeTaSoiree.Daos;

public class Etudiant {
    private String login;
    private String nom;
    private String prenom;
    private String DDN;
    private String mail;
    private String password;

    public Etudiant(String login, String nom, String prenom, String DDN, String mail, String password) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.DDN = DDN;
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDDN() {
        return DDN;
    }

    public void setDDN(String DDN) {
        this.DDN = DDN;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "login='" + login + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", DDN='" + DDN + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
