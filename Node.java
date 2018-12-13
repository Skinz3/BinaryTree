
public class Node
{
	public String Key;
	public String Value;

	public Node Right, Left;

	public boolean IsLeaf()
	{
		return Right == null && Left == null;
	}
	public boolean GotSingleChild()
	{
		return (Right == null && Left != null) | (Right != null && Left == null);
	}
	public Node GetSingleChild()
	{
		if (Right == null)
			return Left;
		else
			return Right;
		
		
	}
	public Node(String key, String value)
	{
		this.Key = key;
		this.Value = value;
	}

}