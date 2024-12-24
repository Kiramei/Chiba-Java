//プロジェクト: enshu12, パッケージ: enshu12, クラス: ListComparator
package enshu12;

import java.util.Comparator;

public class ListComparator implements Comparator<Note> {
    public int compare(Note a, Note b) {
        return Double.compare(a.getTime(), b.getTime());
    }
}