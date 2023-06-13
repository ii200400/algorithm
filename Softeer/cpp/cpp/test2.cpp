// n�� 1���̴� ����Ž���� ���� �ƴϰ�
// ���� �𸣰� ����Ž���� �������µ� �� ���� �𸣰ڰ�..
// �켱 a�� b �������� ���� ����.. ���� �����ϸ� �ȵǰ�.. (����2)

// �� �Է��� �޾ƿ��鼭.. ��������� ���� �� ���� �߿��� ���� ���� ���� �̰� 
// �� ���� �������� �ִ��� ���� �ս��� �Ͼ���� �����? �� �� ����...? 
// ����2�� �ٽú���! ��������� ���簢���� ������ ��� ��������� ����ؼ� ����� ���� �ƴϾ���!
// ����? ����Ž���� �³�? ���� ��� �˾���? ������????

// �����ϴٺ��� ����Ž���� �ƴ��� �˾Ҵ�. set�� Ȱ���ؼ� �ĺ��� �͵��� ���� ��� ����ϴ� ������� �غ��ڴ�.
// unordered_set�� ����ص� �� �� �����ѵ�..? �ϴ� �Ѵ�.

#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

long long solution(int n, vector<int> a, vector<int> b) {
    // ��� ��������� ���̰� ���簢���� ���� ���� �ĺ�(canBe!)��� �����Ѵ�.
    set<int> canBe;
    for (int i = 0; i < n; i++) {
        canBe.insert(a[i]);
        canBe.insert(b[i]);
    }

    // ���簢���� ���� ����(length) �ĺ��� ���簢���� ũ��
    long long answer = 0;
    
    for (int length : canBe) {
        long long boxSize = 0;

        cout << "length : " << length << " ";
        for (int i = 0; i < n; i++) {
            if (a[i] >= length) {
                // �� ��� ���簢���� ���� ���̺��� ũ�ٸ� �� ���� ���� �������� �ؼ� �̾���δ�.
                // ��, ���簢���� �� Ŀ������ �� ū ���� �������� ���־�� �Ѵ�.
                if (b[i] >= length) {
                    cout << " + " << length * std::max(a[i], b[i]) << " ";
                    boxSize += length * std::max(a[i], b[i]);
                } // �� ���� ��ٸ� �� ���� �������� �ؼ� �̾���δ�. (�� ���� ���� �������� �ٿ�����.)
                else {
                    cout << " + " << length * b[i] << " ";
                    boxSize += length * b[i];
                }
            } // �� ���� ��ٸ� �� ���� �������� �ؼ� �̾���δ�.
            else if (b[i] >= length) {
                cout << " + " << length * a[i] << " ";
                boxSize += length * a[i];
            }
            // �� �� ��� ���簢���� ���� ���̺��� �۴ٸ� �� ����� ������.
            // ��Ȯ���� ������ ���� �ƴ϶� �Ѳ����� ������ Ȥ�� ���ʿ� �ξ� ���� ���簢���� ���Խ�Ű�� �ʵ��� ����� ��
        }
        cout << endl;

        if (boxSize > answer) {
            answer = boxSize;
        }
    }

    return answer;
}

void main() {
    long long ans = solution(4, vector<int> {3, 2, 4, 2}, vector<int> {3, 1, 7, 5});
    cout << ans << endl;
}