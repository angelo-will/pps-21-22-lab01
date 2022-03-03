package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CircularListImpl implements CircularList{

    private final List<Integer> list;
    private int index;

    public CircularListImpl() {
        this.list = new ArrayList<>();
//        this.index = 0;
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

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }

    private int nextIndex() {
        this.index = index+1 < this.size() ? index : this.size()-1;
        return this.index++;
    }

    private int prevIndex() {
        this.index = index-1 >= 0 ? index-1 : this.size()-1;
        return this.index;
    }
}
