package osc.diskscheduling.algorithm;

import java.util.Iterator;

/**
 * Implementation of Look and CLook algorithm.
 */
public class C_Look extends Scan_Look {
	
	public C_Look(Iterator<Integer> itQueue) {
		super(itQueue);
	}
	
	/**
	 * Look Algorithm.
	 */
	@Override
	public void first_scan_look() {
		scan_look_default();
		mergeSort(displacementCounter, requestQueue.size() - 1, true);
		absoluteSetSeekTime();
	}
	
	/**
	 * CLook algorithm.
	 */
	@Override
	public void shortest_cscan_clook() {
		cscan_clook_default();
		absoluteSetSeekTime();
		//The jump from outermost request to innermost request has no seek difference.
		requestQueue.get(displacementCounter).setSeekTime(0);
	}
}
