Const MAXACHIEVEMENTS% = 46

Type Achievements
	Field Achievement%[MAXACHIEVEMENTS]
	Field AchievementStrings$[MAXACHIEVEMENTS]
	Field AchievementDescs$[MAXACHIEVEMENTS]
	Field AchvIMG%[MAXACHIEVEMENTS]
	Field AchvLocked%
End Type

Global achv.Achievements = New Achievements

Global UsedConsole%

; ~ Achievements ID Constants
;[Block]
Const Achv005% = 0, Achv008% = 1, Achv012% = 2, Achv035% = 3, Achv049% = 4, Achv055% = 5, Achv066% = 6,  Achv079% = 7, Achv096% = 8, Achv106% = 9
Const Achv148% = 10, Achv205% = 11, Achv268% = 12, Achv294% = 13, Achv372% = 14, Achv409% = 15, Achv420J% = 16, Achv427% = 17, Achv500% = 18, Achv513% = 19
Const Achv588% = 20, Achv714% = 21, Achv789J% = 22, Achv860% = 23, Achv895% = 24, Achv914% = 25, Achv939% = 26, Achv966% = 27, Achv970% = 28
Const Achv1025% = 29, Achv1048% = 30, Achv1123% = 31, Achv1162_ARC% = 32, Achv1499% = 33, Achv2022% = 34

Const AchvConsole% = 35, AchvHarp% = 36, AchvMaynard% = 37, AchvKeter% = 38, AchvKeyCard6% = 39, AchvOmni% = 40
Const AchvO5% = 41, AchvMTF% = 42, AchvPD% = 43, AchvSNAV% = 44, AchvTesla% = 45
;[End Block]

Const AchievementsFile$ = "Data\Achievements.ini"

Function GiveAchievement%(AchvName%, ShowMessage% = True)
	If achv\Achievement[AchvName] <> True Then
		achv\Achievement[AchvName] = True
		If opt\AchvMsgEnabled And ShowMessage Then
			Local Loc2% = GetINISectionLocation(AchievementsFile, "a" + AchvName)
			Local AchievementName$ = GetINIString2(AchievementsFile, Loc2, "AchvName")
			
			CreateAchievementMsg(AchvName, AchievementName)
		EndIf
	EndIf
End Function

Function AchievementTooltip%(AchvNo%)
	Local Scale# = opt\GraphicHeight / 768.0

	SetFont(fo\FontID[Font_Digital])
	
	Local Width% = StringWidth(achv\AchievementStrings[AchvNo])
	
	SetFont(fo\FontID[Font_Default])
	If StringWidth(achv\AchievementDescs[AchvNo]) > Width Then Width = StringWidth(achv\AchievementDescs[AchvNo])
	Width = Width + (20 * MenuScale)
	
	Local Height% = 38 * Scale
	
	Color(25, 25, 25)
	Rect(ScaledMouseX() + (20 * MenuScale), ScaledMouseY() + (20 * MenuScale), Width, Height, True)
	Color(150, 150, 150)
	Rect(ScaledMouseX() + (20 * MenuScale), ScaledMouseY() + (20 * MenuScale), Width, Height, False)
	SetFont(fo\FontID[Font_Digital])
	Text(ScaledMouseX() + (20 * MenuScale) + (Width / 2), ScaledMouseY() + (35 * MenuScale), achv\AchievementStrings[AchvNo], True, True)
	SetFont(fo\FontID[Font_Default])
	Text(ScaledMouseX() + (20 * MenuScale) + (Width / 2), ScaledMouseY() + (55 * MenuScale), achv\AchievementDescs[AchvNo], True, True)
End Function

Function RenderAchvIMG%(x%, y%, AchvNo%)
	Local Row%
	Local Scale# = opt\GraphicHeight / 768.0
	Local SeparationConst2# = 76.0 * Scale
	
	Row = (AchvNo Mod 4)
	Color(0, 0, 0)
	Rect((x + ((Row) * SeparationConst2)), y, 64 * Scale, 64 * Scale, True)
	If achv\Achievement[AchvNo] = True Then
		DrawImage(achv\AchvIMG[AchvNo], (x + (Row * SeparationConst2)), y)
	Else
		DrawImage(achv\AchvLocked, (x + (Row * SeparationConst2)), y)
	EndIf
	Color(50, 50, 50)
	
	Rect((x + (Row * SeparationConst2)), y, 64 * Scale, 64 * Scale, False)
End Function

Global CurrAchvMSGID% = 0

Type AchievementMsg
	Field AchvID%
	Field Txt$
	Field MsgX#
	Field MsgTime#
	Field MsgID%
End Type

Function CreateAchievementMsg.AchievementMsg(ID%, Txt$)
	Local amsg.AchievementMsg
	
	amsg.AchievementMsg = New AchievementMsg
	amsg\AchvID = ID
	amsg\Txt = Txt
	amsg\MsgX = 0.0
	amsg\MsgTime = fps\Factor[1]
	amsg\MsgID = CurrAchvMSGID
	CurrAchvMSGID = CurrAchvMSGID + 1
	
	Return(amsg)
End Function

Function UpdateAchievementMsg%()
	Local amsg.AchievementMsg, amsg2.AchievementMsg
	Local Scale# = opt\GraphicHeight / 768.0
	Local Width% = 264.0 * Scale
	Local Height% = 84.0 * Scale
	Local x%, y%
	
	For amsg.AchievementMsg = Each AchievementMsg
		If amsg\MsgTime <> 0.0 Then
			If amsg\MsgTime > 0.0 And amsg\MsgTime < 70.0 * 7.0 Then
				amsg\MsgTime = amsg\MsgTime + fps\Factor[1]
				If amsg\MsgX > -Width Then amsg\MsgX = Max(amsg\MsgX - (4.0 * fps\Factor[1]), -Width)
			ElseIf amsg\MsgTime >= 70.0 * 7.0
				amsg\MsgTime = -1.0
			ElseIf amsg\MsgTime = -1.0
				If amsg\MsgX < 0.0 Then
					amsg\MsgX = Min(amsg\MsgX + (4.0 * fps\Factor[1]), 0.0)
				Else
					amsg\MsgTime = 0.0
				EndIf
			EndIf
		Else
			Delete(amsg)
		EndIf
	Next
End Function

Function RenderAchievementMsg%()
	Local amsg.AchievementMsg, amsg2.AchievementMsg
	Local Scale# = opt\GraphicHeight / 768.0
	Local Width% = 264.0 * Scale
	Local Height% = 84.0 * Scale
	Local x%, y%
	
	For amsg.AchievementMsg = Each AchievementMsg
		If amsg\MsgTime <> 0.0 Then
			x = opt\GraphicWidth + amsg\MsgX
			y = 0
			For amsg2.AchievementMsg = Each AchievementMsg
				If amsg2 <> amsg Then
					If amsg2\MsgID > amsg\MsgID Then y = y + Height 
				EndIf
			Next
			RenderFrame(x, y, Width, Height)
			Color(0, 0, 0)
			Rect(x + (10.0 * Scale), y + (10.0 * Scale), 64.0 * Scale, 64.0 * Scale)
			DrawImage(achv\AchvIMG[amsg\AchvID], x + (10 * Scale), y + 10 * Scale)
			Color(50, 50, 50)
			Rect(x + (10.0 * Scale), y + (10.0 * Scale), 64.0 * Scale, 64.0 * Scale, False)
			Color(255, 255, 255)
			SetFont(fo\FontID[Font_Default])
			RowText("Achievement Unlocked - " + amsg\Txt, x + (84.0 * Scale), y + (10.0 * Scale), Width - (94.0 * Scale), y - (20.0 * Scale))
		EndIf
	Next
End Function

;~IDEal Editor Parameters:
;~C#Blitz3D