//プロジェクト: enshu12, パッケージ: enshu12, クラス: MySynthesizer
package enshu12;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MySynthesizer {
    private MidiChannel[] channel;
    private Synthesizer synthesizer;

    public MySynthesizer() {
        try {
            synthesizer = MidiSystem.getSynthesizer();
            // シンセサイザの取得 (クラスメソッドなのでインスタンス化不要)
        } catch (MidiUnavailableException e) {
            System.err.println("MIDIシステムが利用できません");
            return;
        }
        try {
            synthesizer.open(); // シンセサイザを開く
        } catch (MidiUnavailableException e) {
            System.err.println("MIDIデバイスが開けません");
            return;
        }
        channel = synthesizer.getChannels();
        // チャンネル配列を取得(通常16チャンネルが同時再生可能となる)
    }

    public void noteOn(int chanNum, Note event) {
        channel[chanNum].noteOn(event.getNoteNum(), event.getVelocity());
        // ノートオンメッセージを一つ送る
    }

    public void setInst(int chanNum, int gmNum) {
        channel[chanNum].programChange(gmNum - 1); // 楽器指定1-128→0-127で指定
    }

    public void close() {
        synthesizer.close(); // シンセサイザをクローズ
    }
}