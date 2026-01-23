class Solution {

    static class Pair {
        long sum;
        int idx;

        Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return sum == p.sum && idx == p.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum, idx);
        }
    }

    public int minimumPairRemoval(int[] nums) {

        int n = nums.length;

        // to contain integer overflow
        long[] long_nums = new long[n];
        int unsorted_pairs = 0;                     // number of unsorted adjacent pairs

        TreeSet<Pair> min_pair = new TreeSet<>(
            (a, b) -> {
                if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
                return Integer.compare(a.idx, b.idx);
            }
        );

        int[] nextidx = new int[n];
        int[] previdx = new int[n];
        int operations = 0;

        long_nums[0] = nums[0];
        nextidx[0] = 1;
        previdx[0] = -1;

        for (int i = 1; i < n; i++) {
            long_nums[i] = nums[i];

            if (nums[i] < nums[i - 1]) unsorted_pairs++;

            nextidx[i] = i + 1;
            previdx[i] = i - 1;

            min_pair.add(new Pair(long_nums[i] + long_nums[i - 1], i - 1));
        }

        while (unsorted_pairs > 0) {

            Pair cur = min_pair.first();
            min_pair.remove(cur);

            int first = cur.idx;
            int second = nextidx[first];

            int left_first = previdx[first];
            int right_second = nextidx[second];

            long replace = long_nums[first] + long_nums[second];

            if (long_nums[first] > long_nums[second]) {
                unsorted_pairs--;
            }

            // left side check
            if (left_first >= 0) {
                if (long_nums[left_first] > long_nums[first] &&
                    long_nums[left_first] <= replace) {
                    unsorted_pairs--;
                }
                else if (long_nums[left_first] <= long_nums[first] &&
                         long_nums[left_first] > replace) {
                    unsorted_pairs++;
                }
            }

            // right side check
            if (right_second < n) {
                if (long_nums[right_second] < long_nums[second] &&
                    long_nums[right_second] >= replace) {
                    unsorted_pairs--;
                }
                else if (long_nums[right_second] >= long_nums[second] &&
                         long_nums[right_second] < replace) {
                    unsorted_pairs++;
                }
            }

            // update left adjacent pair
            if (left_first >= 0) {
                min_pair.remove(
                    new Pair(long_nums[left_first] + long_nums[first], left_first)
                );
                min_pair.add(
                    new Pair(long_nums[left_first] + replace, left_first)
                );
            }

            // update right adjacent pair
            if (right_second < n) {
                min_pair.remove(
                    new Pair(long_nums[right_second] + long_nums[second], second)
                );
                min_pair.add(
                    new Pair(long_nums[right_second] + replace, first)
                );
                previdx[right_second] = first;
            }

            nextidx[first] = right_second;
            long_nums[first] = replace;

            operations++;
        }

        return operations;
    }
}