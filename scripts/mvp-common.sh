#!/usr/bin/env bash

function class_name_2_file_name() {
	char_arr=$(echo $1 | awk 'BEGIN{FS=""}{for(i=1;i<=NF;i++)print $i}')

	result=""
	index=0
	for char in $char_arr;do
		ascii=$(printf "%d" "'${char}")

		if ((ascii >= 65)) && ((ascii <= 90));then
			let lower_case_ascii=ascii+32
			lower_case_char=$(echo $lower_case_ascii | awk '{printf("%c", $1)}')

			if [ $index == 0 ];then
				result="${result}${lower_case_char}"
			else
				result="${result}_${lower_case_char}"
			fi

		else
			result="${result}${char}"
		fi

		let index=index+1
	done

	echo $result
}

function first_char_to_lower_case() {
	char_arr=$(echo $1 | awk 'BEGIN{FS=""}{for(i=1;i<=NF;i++)print $i}')

	result=""
	index=0
	for char in $char_arr;do
	    if [ $index == 0 ];then
		    ascii=$(printf "%d" "'${char}")
            if ((ascii >= 65)) && ((ascii <= 90));then
                let lower_case_ascii=ascii+32
                lower_case_char=$(echo $lower_case_ascii | awk '{printf("%c", $1)}')
                result="${result}${lower_case_char}"
            else
                result="${result}${char}"
            fi
        else
            result="${result}${char}"
        fi

		let index=index+1
	done

	echo $result
}