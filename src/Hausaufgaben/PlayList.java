package Hausaufgaben;

public class PlayList {
    //attribs
    private String[] aSongs;
    private String playListName;

    //methods
    //constructor
    public PlayList(String pName, String[] psongs){
        aSongs = psongs;
        playListName = pName;
    }

    //getter
    public String getName(){return playListName;}

    //setter
    public void setName(String pName){ playListName = pName;}

    //getSong
    public String getSongWithName(String pSongName){
        if (pSongName != null){
            for (int i=0; i<= aSongs.length;i++){
                if (aSongs[i].equals(pSongName)){
                    return aSongs[i];
                }
            }
        }
        return "None";
    }
    //addSong
    public void addNewSong(String pSongName){
        if (pSongName != null){
            for (int i=0; i<= aSongs.length;i++){
                if (aSongs[i] != null){
                    aSongs[i] = pSongName;
                    break;
                }
            }
            System.out.println("PlayList voll!!");
        }
    }
    //countSongs
    public int countSong(){
        int count = 0;
            for (int i=0; i<= aSongs.length;i++){
                count++;
            }
        return count;
    }

    //main
    public static void main(String[] args) {
        System.out.println("Hello");

    }
}

