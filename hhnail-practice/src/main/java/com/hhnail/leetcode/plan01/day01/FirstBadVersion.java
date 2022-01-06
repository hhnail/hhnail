package com.hhnail.leetcode.plan01.day01;


class VersionControl {
	public boolean isBadVersion(long bad) {
		if (bad >= 1702766719) {
			return true;
		}
		return false;
	}
}

public class FirstBadVersion extends VersionControl {

	public static void main(String[] args) {
		FirstBadVersion f = new FirstBadVersion();

		// for (int i = 0; i < 5; i++) {
		// 	System.out.println(f.isBadVersion(i+1));
		// }

		System.out.println(f.firstBadVersion(2126753390));
	}

	// f f f t t t t t
	public int firstBadVersion(int n) {
		FirstBadVersion f = new FirstBadVersion();

		int leftBound = 1;
		int rightBound = n;
		while (leftBound <= rightBound) {

			if ((rightBound - leftBound) <= 1) {
				return f.isBadVersion(leftBound) ? leftBound : rightBound;
			}

			// int mid = (int)(((long)leftBound + (long)rightBound) / 2);
			int mid = leftBound + (rightBound - leftBound) / 2; // 防止计算时溢出

			if (f.isBadVersion(mid)) {
				rightBound = mid;
			} else {
				leftBound = mid;
			}
		}
		return -1;
	}
}

