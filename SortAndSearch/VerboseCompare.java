public interface VerboseCompare extends Comparable {
    int compareTo (Object other);
    int getCount() ;
    void resetCount() ;
    void setVerbose() ;
}
