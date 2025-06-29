class Pair_knapsack {
    int val;     // value
    int wt;      // weight
    double ratio;

    Pair_knapsack(int val, int wt) {
        this.val = val;
        this.wt = wt;
        this.ratio = (double) val / wt;
    }
}

