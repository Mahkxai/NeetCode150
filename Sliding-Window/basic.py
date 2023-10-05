'''
	Basic concept: sum of each subarray of size k
	k <= len(arr)
'''

def sumSubArray(arr, k):
	if k > len(arr):
		print(f'Error: k = {k} is greater than size of array({len(arr)})!')
		return
	
	sub_sum = 0
	sub_arr = []
	sub_arr_list = []

	for i in range(0, k):
		sub_sum += arr[i]
		sub_arr.append(arr[i])
	
	sub_arr_list.append(f'{sub_arr} -> {sub_sum}')

	for j in range(k+1, len(arr)):
		sub_sum -= sub_arr.pop(0)
		sub_sum += arr[j]
		sub_arr.append(arr[j])
		sub_arr_list.append(f'{sub_arr} -> {sub_sum}')

	for item in sub_arr_list: print(item)


sample_arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
k = 90

sumSubArray(sample_arr, k)