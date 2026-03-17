package avlsearch;

public interface MyTree {
	// a unified interface but leave the details of the underlying node 
	// to the tree to determine
	public void insert (String word);
	
	public void searchPrefix( String word);

}
