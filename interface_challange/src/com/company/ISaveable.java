package com.company;

import java.util.List;

public interface ISaveable {
List<String> write();//here we use List instead of and medium(i.e ArrayList) which we will define when final execution is required
void read(List<String> savedValues);

}
