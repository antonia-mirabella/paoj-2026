package com.pao.laboratory07.exercise1;

public enum StareComanda {
    PLASATA {
        @Override
        public StareComanda next() { return PROCESATA; }
    },
    PROCESATA {
        @Override
        public StareComanda next() { return EXPEDIATA; }
    },
    EXPEDIATA {
        @Override
        public StareComanda next() { return LIVRATA; }
    },
    LIVRATA {
        @Override
        public StareComanda next() { return LIVRATA; }
    },
    ANULATA {
        @Override
        public StareComanda next() { return ANULATA; }
    };

    public abstract StareComanda next();

    public boolean esteFinala() {
        return this == LIVRATA || this == ANULATA;
    }
}
