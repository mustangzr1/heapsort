package com.oliver.heapsort;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {

	TextView tv1, tv2;
	Button b1;
	int comps = 0;
	int[] a = { 1, 16, 2, 3, 14, 12, 7, 10, 8, 9, 17, 19, 21, 23, 26, 27 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv1 = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);
		b1 = (Button) findViewById(R.id.button1);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			sb.append("" + a[i] + " ");
		}
		tv1.setText(sb.toString());

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				heapsort(a);

			}
		});
	}

	protected void heapsort(int[] a) {
		int[] A = setHeapWithSize(a, a.length);
		buildHeap(A);
		for (int i = a.length; i > 1; i--) {
			a[i - 1] = A[0];
			A[0] = A[i - 1];
			A = setHeapWithSize(A, A.length - 1);
			heapify(A, 1);
		}
		a[0] = A[0];
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			sb2.append("" + a[i] + " ");
		}
		tv2.setText(sb2.toString());
	}

	private void buildHeap(int[] a) {
		for (int i = a.length / 2; i > 0; i--) {
			heapify(a, i);
		}
	}

	private void heapify(int[] a, int i) {
		int l = left(i);
		int r = right(i);
		int largest = 0;
		if (l <= heapSize(a) && a[l - 1] > a[i - 1])
			largest = l;
		else
			largest = i;
		if (r <= heapSize(a) && a[r - 1] > a[largest - 1])
			largest = r;
		if (largest != i) {
			int temp = a[i - 1];
			a[i - 1] = a[largest - 1];
			a[largest - 1] = temp;
			heapify(a, largest);
		}
	}

	private int heapSize(int[] a) {
		return a.length;
	}

	private int parent(int i) {
		return i / 2;
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	private int[] setHeapWithSize(int[] a, int length) {
		return a;
	}

}
