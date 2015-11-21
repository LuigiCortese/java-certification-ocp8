package net.devsedge;

public class NameUtil{
	private static char id='A';
	private static int spacePrefix;
	
	public final String getName(){
		StringBuilder name=new StringBuilder(String.format("%"+((id-'A')*spacePrefix+1)+"s", id));
		for(int i=0;i<name.length();i+=spacePrefix+2)
			name.insert(i,"| ");
		id++;
		return name.toString();
	}
	
	public NameUtil(int spacePrefix_){
		spacePrefix=spacePrefix_;
	}
}