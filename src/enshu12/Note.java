//プロジェクト: enshu12, パッケージ: enshu12, クラス: Note
package enshu12;

public class Note {
    public Note(double time, int noteNum, int velocity) {
        this.time = time;
        this.noteNum = noteNum;
        this.velocity = velocity;
    }

    private double time;
    private int noteNum;
    private int velocity;

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getNoteNum() {
        return noteNum;
    }

    public void setNoteNum(int noteNum) {
        this.noteNum = noteNum;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
