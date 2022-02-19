package model;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lombok.Data;

public class Pokemon {

    private String IDPOK;
    private String NOMPOK;
    private String APEPOK;
    private double EXPHABPOK;
    private String EXPHABPOKString;

    private double ALTPOK;
    private String ALTPOKString;

    private double PESPOK;
    private String PESPOKString;

    private String IMGFROPOK;

    private String IMGATRPOK;

    public String getIDPOK() {
        return IDPOK;
    }

    public void setIDPOK(String IDPOK) {
        this.IDPOK = IDPOK;
    }

    public String getNOMPOK() {
        return NOMPOK;
    }

    public void setNOMPOK(String NOMPOK) {
        this.NOMPOK = NOMPOK;
    }

    public String getAPEPOK() {
        return APEPOK;
    }

    public void setAPEPOK(String APEPOK) {
        this.APEPOK = APEPOK;
    }

    public double getEXPHABPOK() {
        return EXPHABPOK;
    }

    public void setEXPHABPOK(double EXPHABPOK) {
        this.EXPHABPOK = EXPHABPOK;
    }

    public String getEXPHABPOKString() {
        return EXPHABPOKString;
    }

    public void setEXPHABPOKString(String EXPHABPOKString) {
        this.EXPHABPOKString = EXPHABPOKString;
    }

    public double getALTPOK() {
        return ALTPOK;
    }

    public void setALTPOK(double ALTPOK) {
        this.ALTPOK = ALTPOK;
    }

    public String getALTPOKString() {
        return ALTPOKString;
    }

    public void setALTPOKString(String ALTPOKString) {
        this.ALTPOKString = ALTPOKString;
    }

    public double getPESPOK() {
        return PESPOK;
    }

    public void setPESPOK(double PESPOK) {
        this.PESPOK = PESPOK;
    }

    public String getPESPOKString() {
        return PESPOKString;
    }

    public void setPESPOKString(String PESPOKString) {
        this.PESPOKString = PESPOKString;
    }

    public String getIMGFROPOK() {
        return IMGFROPOK;
    }

    public void setIMGFROPOK(String IMGFROPOK) {
        this.IMGFROPOK = IMGFROPOK;
    }

    public String getIMGATRPOK() {
        return IMGATRPOK;
    }

    public void setIMGATRPOK(String IMGATRPOK) {
        this.IMGATRPOK = IMGATRPOK;
    }

   
    
}
