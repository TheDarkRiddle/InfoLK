package Metavers;

import java.lang.reflect.Array;

public class Acount{
    private Avatar avatar;
    private Programm[] aProgramme;

    public Acount( Avatar pAvatar, int programmCount){
        avatar = pAvatar;
        aProgramme = new Programm[programmCount];
    }
    public void addPrgramm(Programm newProgramm){
        for(int i =0; i< aProgramme.length; i++){
            if(aProgramme[i] == null){
                aProgramme[i] = newProgramm;
                break;
            }
        }
    }
    public void newAvatarName(String newName){
        if (newName != null && ( !newName.equals(avatar.getName()) ) ){
            avatar.setName(newName);
        }
    }
}
