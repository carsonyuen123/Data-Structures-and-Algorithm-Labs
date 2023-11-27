package Q_LE2;

    public class Pair<Y extends Number, N> {
    //define variables key and value
        private Y key;
        private N value;

        //create constructor
        public Pair(Y key, N value){
            this.key = key;
            this.value= value;
        }

        //define setters
        public void setKey(Y key){
            this.key = key;
        }

        public void setValue(N value) {
            this.value = value;
        }

        //define getters
        public Y getKey(){
            return key;
        }

        public N getValue(){
            return value;
        }
    }



