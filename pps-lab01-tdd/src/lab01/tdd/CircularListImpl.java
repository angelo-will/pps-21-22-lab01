package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private final List<Integer> list;
    private int index;

    public CircularListImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(final int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(nextIndex()));
    }

    @Override
    public Optional<Integer> previous() {
        return this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(prevIndex()));
    }

    @Override
    public void reset() {
        this.index = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }

    private int nextIndex() {
        this.index = index < this.size() ? index : 0;
        return this.index++;
    }

    private int prevIndex() {
        this.index = index > 0 ? index : this.size();
        return --this.index;
    }
}
