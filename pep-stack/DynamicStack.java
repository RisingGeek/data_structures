class DynamicStack extends Stack {
    public DynamicStack() {
        super();
    }

    public DynamicStack(int cap) {
        super(cap);
    }

    @Override
    public void push(int val) throws Exception {
        try {
            super.push(val);
        } catch (Exception e) {
            int[] temp = new int[super.size()];
            for (int i = temp.length - 1; i >= 0; i--) {
                temp[i] = super.top();
                super.pop();
            }
            super.resize(2 * temp.length);
            for (int i = 0; i < temp.length; i++) {
                super.push(temp[i]);
            }
            super.push(val);
        }
    }

}