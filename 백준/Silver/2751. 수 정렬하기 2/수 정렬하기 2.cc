#include <iostream>

using namespace std;

int main(){
	int n, temp = 0;
	cin >> n;

	bool* cnt = new bool[2000001];
	for (int i = 0; i < 2000002; i++){
		cnt[i] = false;
	}

	for (int i = 0; i < n; i++){
		cin >> temp;
		if (temp < 0){
			temp = 2000001 + temp;
		}
		cnt[temp] = true;
	}
	for (int i = 1000001; i < 2000001;i+=1){
		if (cnt[i]){
			cout << i - 2000001 << "\n";
		}
	}
	for (int i = 0; i < 1000001; i += 1){
		if (cnt[i]){
			cout << i << "\n";
		}
	}

	return 0;
}