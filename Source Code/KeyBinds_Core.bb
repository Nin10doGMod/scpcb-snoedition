Type Keys
	Field Name$[211]
	Field MOVEMENT_LEFT%, MOVEMENT_RIGHT%, MOVEMENT_UP%, MOVEMENT_DOWN%
	Field CONSOLE%, INVENTORY%, SPRINT%, BLINK%, SAVE%, CROUCH%, SCREENSHOT%
End Type

Global key.Keys = New Keys

key\Name[1] = "Esc"

Local i%

For i = 2 To 10
	key\Name[i] = i - 1
Next

key\Name[11] = "0"
key\Name[12] = "-"
key\Name[13] = "="
key\Name[14] = "Backspace"
key\Name[15] = "TAB"
key\Name[16] = "Q"
key\Name[17] = "W"
key\Name[18] = "E"
key\Name[19] = "R"
key\Name[20] = "T"
key\Name[21] = "Y"
key\Name[22] = "U"
key\Name[23] = "I"
key\Name[24] = "O"
key\Name[25] = "P"
key\Name[26] = "["
key\Name[27] = "]"
key\Name[28] = "Enter"
key\Name[29] = "Left Ctrl"
key\Name[30] = "A"
key\Name[31] = "S"
key\Name[32] = "D"
key\Name[33] = "F"
key\Name[34] = "G"
key\Name[35] = "H"
key\Name[36] = "J"
key\Name[37] = "K"
key\Name[38] = "L"
key\Name[39] = ";"
key\Name[40] = "'"
key\Name[42] = "Left Shift"
key\Name[43] = "\"
key\Name[44] = "Z"
key\Name[45] = "X"
key\Name[46] = "C"
key\Name[47] = "V"
key\Name[48] = "B"
key\Name[49] = "N"
key\Name[50] = "M"
key\Name[51] = ","
key\Name[52] = "."
key\Name[54] = "Right Shift"
key\Name[56] = "Left Alt"
key\Name[57] = "Space"
key\Name[58] = "Caps Lock"
key\Name[59] = "F1"
key\Name[60] = "F2"
key\Name[61] = "F3"
key\Name[62] = "F4"
key\Name[63] = "F5"
key\Name[64] = "F6"
key\Name[65] = "F7"
key\Name[66] = "F8"
key\Name[67] = "F9"
key\Name[68] = "F10"
key\Name[157] = "Right Control"
key\Name[184] = "Right Alt"
key\Name[200] = "Up"
key\Name[203] = "Left"
key\Name[205] = "Right"
key\Name[208] = "Down"

;~IDEal Editor Parameters:
;~C#Blitz3D