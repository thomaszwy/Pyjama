package Domain.DataType;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class TreeNode<T> implements Iterable<TreeNode<T>> {

    public T data;
    public TreeNode<T> parent;
    public List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new LinkedList<TreeNode<T>>();
    }

    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

	@Override
	public Iterator<TreeNode<T>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}