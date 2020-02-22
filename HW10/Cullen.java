public class Cullen{
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		//System.out.println(list.size());
		//System.out.println(list.isEmpty());
		list.addAtIndex("zero", 0);
		//System.out.println(list.get(0));
		//System.out.println(list.size());
		//System.out.println(list.isEmpty());
		list.addAtIndex("one",1);
		//System.out.println(list.size());
		//System.out.println(list.contains("one"));
		// list.addAtIndex("ZERO", 0);
		// System.out.println(list.get(0));
		// System.out.println(list.size());
		list.addAtIndex("Two", 2);
		list.addAtIndex("Three", 3);
		System.out.println(list.get(4));
		// list.get(1);
		// System.out.println(list.contains("Two"));
		// System.out.println(list.getNode(0).getData());
		// System.out.println(list.getNode(1).getData());
		// System.out.println(list.getNode(2).getData());
		// System.out.println(list.getNode(3).getData());
		// for (int i = 0; i < list.size(); i++) {
		// 	System.out.println(list.getNode(i).getData());
		// }

		// list.removeAtIndex(0);
		// System.out.println(list.size());
		// System.out.println(list.getNode(0).getData());
		// System.out.println(list.getNode(1).getData());
		// System.out.println(list.getNode(2).getData());
		// System.out.println(list.getNode(3).getData());

	}
}