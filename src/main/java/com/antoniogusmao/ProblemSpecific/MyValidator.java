package com.antoniogusmao.ProblemSpecific;

import com.antoniogusmao.Optimizer.Validator;
import com.antoniogusmao.ProblemSpecific.State;

public class MyValidator implements Validator<State> {
    private int timeLimit;
    
    @Override
    public boolean isValid(State s) {
        // TODO increase performance by updating validity after each action.
        return s.caches.stream().noneMatch(r -> r.getFreeCapacity() < 0);
    }

}
