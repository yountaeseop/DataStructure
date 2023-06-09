package unionFind;

import java.util.ArrayList;

public class UnionFind {
	public Node[] a;

	public UnionFind(Node[] a) {
		this.a = a;
	}
// 내가 작성했던 코드	
//	private int find(int index) {
//		int parentInt;
//		ArrayList<Integer> indexList = new ArrayList<Integer>();
//		
//		while(true) {
//			parentInt=a[index].getParent();
//			
//			indexList.add(index);
//			
//			// 경로 압축 코드 - 경로상 노드의 인덱스를 저장
//			if(index == parentInt) {
//				for(int i = 0; i < indexList.size(); i++) {
//					int indexOfList = indexList.get(i);
//					a[indexOfList].setParent(parentInt);
//				}
//				// 인덱스와 getParent값이 같을 경우,
//				//자기 자신이 부모일 경우가 그 집합의 root이다.
//				break;
//			}
//			index = parentInt;
//		}
//		return parentInt;
//	}
	
	// find함수는 재귀로 작성하는 것이 간편!
	// 인덱스를 주고 값을 뽑아네는 함수
	protected int find(int i) {
		if( i != a[i].getParent()) {
			a[i].setParent(find(a[i].getParent()));
		}
		return a[i].getParent();
	}
	
	//Node안의 Rank를 기반으로 합친다.
	public void union(int i, int j) {
		int rankOfI = a[find(i)].getRank();
		int rankOfj = a[find(j)].getRank();
		
		if(find(i) == find(j)) { // 루트 노드가 동일하면 더이상의 수행없이 그대로 리턴
			return;
		}
		
		if(rankOfI > rankOfj) { // i > j
			a[find(j)].setParent(a[find(i)].getParent());
			
			// 집합끼리 서로 붙였을때 밑에 붙여진 집합트리전체의 랭크를
			// 1씩 빼야한다.
		} else if(rankOfI < rankOfj) { // j < i
			a[find(i)].setParent(a[find(j)].getParent());
		} else { // i = j
			// i에다가 j를 붙이는 것을 임의로 설정
			
			a[find(j)].setParent(a[find(i)].getParent());
			a[find(i)].setRank(a[find(i)].getRank()+1);
					
		}
		
	}
	
	// 단답형 40 프로그래밍 코딩 40(손코딩)
	
}
