package gfraisse.ImposeTaSoiree.Daos;

public class Soiree {
    private String libelleCourt;
    private String Descriptif;
    private String dateDebut;
    private String heureDebut;
    private String lat;
    private String lng;
    private String Adr;

    public Soiree(String libelleCourt, String descriptif, String dateDebut, String heureDebut, String lat, String lng, String adr) {
        this.libelleCourt = libelleCourt;
        this.Descriptif = descriptif;
        this.dateDebut = dateDebut;
        this.heureDebut = heureDebut;
        this.lat = lat;
        this.lng = lng;
        this.Adr = adr;
    }



    public String getLibelleCourt() {
        return libelleCourt;
    }

    public void setLibelleCourt(String libelleCourt) {
        this.libelleCourt = libelleCourt;
    }

    public String getDescriptig() {
        return Descriptif;
    }

    public void setDescriptig(String descriptif) {
        Descriptif = descriptif;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAdr() {
        return Adr;
    }

    public void setAdr(String adr) {
        Adr = adr;
    }

    @Override
    public String toString() {
        return "Soiree{" +
                "libelleCourt='" + libelleCourt + '\'' +
                ", Descriptif='" + Descriptif + '\'' +
                ", dateDebut='" + dateDebut + '\'' +
                ", heureDebut='" + heureDebut + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", Adr='" + Adr + '\'' +
                '}';
    }
}
