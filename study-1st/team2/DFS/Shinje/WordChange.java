class Solution {
    public int solution(String begin, String target, String[] words) {
		int answer = 0;

		if(isTargetFound(target, words) == false)//target이 없으면 0을 반환
			return 0;

		/**
		 *for(int i=0; i<words.length; i++)
		 *{
		 *	1. begin과 words[i]의 문자열을 비교하여 다른 것이 딱 1개이면
		 *	2. count++
		 *	3. words에서 begin과 일치하는 것을 삭제하고
		 *	4. if (words[i] == target) count 리턴
		 *	5. else begin = words[i]
		 *}
		 */

		return answer;
	}


	/**
	 * words 배열 안에 target이 있는지 확인하는 메소드
	 * @param target
	 * @param words
	 * @return
	 */
	public boolean isTargetFound(String target, String[] words) {
		boolean answer = false;

		for(String word : words) {
			if(target.equals(word))
				answer = true;
		}

		return answer;
	}
}
