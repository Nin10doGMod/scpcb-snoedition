Const MaxDecalTextureIDAmount% = 21

Type DecalInstance
	Field DecalTextureID%[MaxDecalTextureIDAmount]
End Type

Global de_I.DecalInstance

; ~ Decal Texture ID Constants
;[Block]
Const DECAL_CORROSIVE_1% = 0
Const DECAL_CORROSIVE_2% = 1

Const DECAL_BLOOD_1% = 2
Const DECAL_BLOOD_2% = 3
Const DECAL_BLOOD_3% = 4
Const DECAL_BLOOD_4% = 5
Const DECAL_BLOOD_5% = 6
Const DECAL_BLOOD_6% = 7

Const DECAL_PD_1% = 8
Const DECAL_PD_2% = 9
Const DECAL_PD_3% = 10
Const DECAL_PD_4% = 11
Const DECAL_PD_5% = 12
Const DECAL_PD_6% = 13

Const DECAL_BULLET_HOLE_1% = 14
Const DECAL_BULLET_HOLE_2% = 15

Const DECAL_BLOOD_DROP_1% = 16
Const DECAL_BLOOD_DROP_2% = 17

Const DECAL_GOOP% = 18
Const DECAL_QUARTZ% = 19

Const DECAL_WATER% = 20
;[End Block]

Function LoadDecals%()
	Local i%
	
	de_I.DecalInstance = New DecalInstance
	
	For i = DECAL_CORROSIVE_1 To DECAL_CORROSIVE_2
		de_I\DecalTextureID[i] = LoadTexture_Strict("GFX\decals\corrosive(" + i + ").png", 1 + 2, DeleteAllTextures)
	Next
	
	For i = DECAL_BLOOD_1 To DECAL_BLOOD_6
		de_I\DecalTextureID[i] = LoadTexture_Strict("GFX\decals\blood(" + (i - DECAL_BLOOD_1) + ").png", 1 + 2, DeleteAllTextures)
	Next
	
	For i = DECAL_PD_1 To DECAL_PD_6
		de_I\DecalTextureID[i] = LoadTexture_Strict("GFX\decals\pd(" + (i - DECAL_PD_1) + ").png", 1 + 2, DeleteAllTextures)
	Next
	
	For i = DECAL_BULLET_HOLE_1 To DECAL_BULLET_HOLE_2
		de_I\DecalTextureID[i] = LoadTexture_Strict("GFX\decals\bullet_hole(" + (i - DECAL_BULLET_HOLE_1) + ").png", 1 + 2, DeleteAllTextures)
	Next
	
	For i = DECAL_BLOOD_DROP_1 To DECAL_BLOOD_DROP_2
		de_I\DecalTextureID[i] = LoadTexture_Strict("GFX\decals\blood_drop(" + (i - DECAL_BLOOD_DROP_1) + ").png", 1 + 2, DeleteAllTextures)
	Next
	
	de_I\DecalTextureID[DECAL_QUARTZ] = LoadTexture_Strict("GFX\decals\quartz.png", 1 + 2, DeleteAllTextures)
	
	de_I\DecalTextureID[DECAL_GOOP] = LoadTexture_Strict("GFX\decals\goop.png", 1 + 2, DeleteAllTextures)
	
	de_I\DecalTextureID[DECAL_WATER] = LoadTexture_Strict("GFX\decals\water.png", 1 + 2, DeleteAllTextures)
End Function

Const MaxParticleTextureIDAmount% = 8

Type ParticleInstance
	Field ParticleTextureID%[MaxParticleTextureIDAmount]
End Type

Global p_I.ParticleInstance

; ~ Particles ID Constants
;[Block]
Const PARTICLE_BLACK_SMOKE% = 0
Const PARTICLE_WHITE_SMOKE% = 1

Const PARTICLE_FLASH% = 2

Const PARTICLE_DUST% = 3

Const PARTICLE_SHADOW% = 4

Const PARTICLE_SUN% = 5

Const PARTICLE_BLOOD% = 6

Const PARTICLE_SPARK% = 7
;[End Block]

Function LoadParticles%()
	p_I.ParticleInstance = New ParticleInstance
	
	p_I\ParticleTextureID[PARTICLE_BLACK_SMOKE] = LoadTexture_Strict("GFX\particles\smoke(0).png", 1 + 2, DeleteAllTextures)
	p_I\ParticleTextureID[PARTICLE_WHITE_SMOKE] = LoadAnimTexture_Strict("GFX\particles\smoke(1).png", 1 + 2, 256, 256, 0, 4, DeleteAllTextures)
	
	p_I\ParticleTextureID[PARTICLE_FLASH] = LoadTexture_Strict("GFX\particles\flash.png", 1 + 2, DeleteAllTextures)
	
	p_I\ParticleTextureID[PARTICLE_DUST] = LoadTexture_Strict("GFX\particles\dust.png", 1 + 2, DeleteAllTextures)
	
	p_I\ParticleTextureID[PARTICLE_SHADOW] = LoadTexture_Strict("GFX\npcs\hg.pt", 1 + 2, DeleteAllTextures)
	
	p_I\ParticleTextureID[PARTICLE_SUN] = LoadTexture_Strict("GFX\map\textures\sun.png", 1 + 2, DeleteAllTextures)
	
	p_I\ParticleTextureID[PARTICLE_BLOOD] = LoadTexture_Strict("GFX\particles\blood.png", 1 + 2, DeleteAllTextures)
	
	p_I\ParticleTextureID[PARTICLE_SPARK] = LoadTexture_Strict("GFX\particles\spark.png", 1 + 2, DeleteAllTextures)
End Function

Const MaxDoorModelIDAmount% = 9
Const MaxDoorFrameModelIDAmount% = 4
Const MaxButtonModelIDAmount% = 5
Const MaxButtonTextureIDAmount% = 2
Const MaxElevatorPanelTextureIDAmount% = 3

Type DoorInstance
	Field DoorModelID%[MaxDoorModelIDAmount]
	Field DoorFrameModelID%[MaxDoorFrameModelIDAmount]
	Field ButtonModelID%[MaxButtonModelIDAmount]
	Field ButtonTextureID%[MaxButtonTextureIDAmount]
	Field ElevatorPanelModel%
	Field ElevatorPanelTextureID%[MaxElevatorPanelTextureIDAmount%]
	Field SelectedDoor.Doors, ClosestDoor.Doors
	Field ClosestButton%
End Type

Global d_I.DoorInstance

; ~ Door Model ID Constants
;[Block]
Const DOOR_DEFAULT_MODEL% = 0
Const DOOR_ELEVATOR_MODEL% = 1
Const DOOR_HEAVY_MODEL_1% = 2
Const DOOR_HEAVY_MODEL_2% = 3
Const DOOR_BIG_MODEL_1% = 4
Const DOOR_BIG_MODEL_2% = 5
Const DOOR_OFFICE_MODEL% = 6
Const DOOR_WOODEN_MODEL% = 7
Const DOOR_ONE_SIDED_MODEL% = 8
;[End Block]

; ~ Door Frame Model ID Constants
;[Block]
Const DOOR_DEFAULT_FRAME_MODEL% = 0
Const DOOR_BIG_FRAME_MODEL% = 1
Const DOOR_OFFICE_FRAME_MODEL% = 2
Const DOOR_WOODEN_FRAME_MODEL% = 3
;[End Block]

; ~ Button Model ID Constants
;[Block]
Const BUTTON_DEFAULT_MODEL% = 0
Const BUTTON_KEYCARD_MODEL% = 1
Const BUTTON_KEYPAD_MODEL% = 2
Const BUTTON_SCANNER_MODEL% = 3
Const BUTTON_ELEVATOR_MODEL% = 4
;[End Block]

; ~ Button Texture ID Constants
;[Block]
Const BUTTON_GREEN_TEXTURE% = 0
Const BUTTON_RED_TEXTURE% = 1
;[End Block]

; ~ Elevator Panel Texture ID Constants
;[Block]
Const ELEVATOR_PANEL_UP% = 0
Const ELEVATOR_PANEL_DOWN% = 1
Const ELEVATOR_PANEL_IDLE% = 2
;[End Block]

Function LoadDoors%()
	Local i%
	
	d_I.DoorInstance = New DoorInstance
	
	d_I\DoorModelID[DOOR_DEFAULT_MODEL] = LoadMesh_Strict("GFX\map\Props\Door01.x")
	
	d_I\DoorModelID[DOOR_ELEVATOR_MODEL] = LoadMesh_Strict("GFX\map\Props\ElevatorDoor.b3d")
	
	d_I\DoorModelID[DOOR_HEAVY_MODEL_1] = LoadMesh_Strict("GFX\map\Props\HeavyDoor1.x")
	d_I\DoorModelID[DOOR_HEAVY_MODEL_2] = LoadMesh_Strict("GFX\map\Props\HeavyDoor2.x")
	
	d_I\DoorModelID[DOOR_BIG_MODEL_1] = LoadMesh_Strict("GFX\map\Props\contdoorleft.x")
	d_I\DoorModelID[DOOR_BIG_MODEL_2] = LoadMesh_Strict("GFX\map\Props\contdoorright.x")
	
	d_I\DoorModelID[DOOR_OFFICE_MODEL] = LoadAnimMesh_Strict("GFX\map\Props\officedoor.b3d")
	
	d_I\DoorModelID[DOOR_WOODEN_MODEL] = LoadMesh_Strict("GFX\map\Props\DoorWooden.b3d")
	
	d_I\DoorModelID[DOOR_ONE_SIDED_MODEL] = LoadMesh_Strict("GFX\map\Props\Door02.x")
	
	For i = 0 To MaxDoorModelIDAmount - 1
		HideEntity(d_I\DoorModelID[i])
	Next
	
	d_I\DoorFrameModelID[DOOR_DEFAULT_FRAME_MODEL] = LoadMesh_Strict("GFX\map\Props\DoorFrame.b3d")
	
	d_I\DoorFrameModelID[DOOR_BIG_FRAME_MODEL] = LoadMesh_Strict("GFX\map\Props\ContDoorFrame.b3d")
	
	d_I\DoorFrameModelID[DOOR_OFFICE_FRAME_MODEL] = LoadMesh_Strict("GFX\map\Props\officedoorframe.b3d")
	
	d_I\DoorFrameModelID[DOOR_WOODEN_FRAME_MODEL] = LoadMesh_Strict("GFX\map\Props\DoorWoodenFrame.b3d")
	
	For i = 0 To MaxDoorFrameModelIDAmount - 1
		HideEntity(d_I\DoorFrameModelID[i])
	Next
	
	d_I\ElevatorPanelModel = LoadMesh_Strict("GFX\map\Props\elevator_panel.b3d")
	HideEntity(d_I\ElevatorPanelModel)
	
	d_I\ElevatorPanelTextureID[ELEVATOR_PANEL_DOWN] = LoadTexture_Strict("GFX\map\textures\elevator_panel_down.png", 1, DeleteAllTextures)
	d_I\ElevatorPanelTextureID[ELEVATOR_PANEL_UP] = LoadTexture_Strict("GFX\map\textures\elevator_panel_up.png", 1, DeleteAllTextures)
	d_I\ElevatorPanelTextureID[ELEVATOR_PANEL_IDLE] = LoadTexture_Strict("GFX\map\textures\elevator_panel_idle.png", 1, DeleteAllTextures)

	If opt\Atmosphere Then
		For i = ELEVATOR_PANEL_DOWN To ELEVATOR_PANEL_IDLE
			TextureBlend(d_I\ElevatorPanelTextureID[i], 5)
		Next
	EndIf
	
	d_I\ButtonModelID[BUTTON_DEFAULT_MODEL] = LoadMesh_Strict("GFX\map\Props\Button.b3d")
	
	d_I\ButtonModelID[BUTTON_KEYCARD_MODEL] = LoadMesh_Strict("GFX\map\Props\ButtonKeycard.b3d")
	
	d_I\ButtonModelID[BUTTON_KEYPAD_MODEL] = LoadMesh_Strict("GFX\map\Props\ButtonCode.b3d")
	
	d_I\ButtonModelID[BUTTON_SCANNER_MODEL] = LoadMesh_Strict("GFX\map\Props\ButtonScanner.b3d")
	
	d_I\ButtonModelID[BUTTON_ELEVATOR_MODEL] = LoadMesh_Strict("GFX\map\Props\ButtonElevator.b3d")
	
	For i = 0 To MaxButtonModelIDAmount - 1
		HideEntity(d_I\ButtonModelID[i])
	Next
	
	d_I\ButtonTextureID[BUTTON_GREEN_TEXTURE] = LoadTexture_Strict("GFX\map\textures\keypad.jpg", 1, DeleteAllTextures)
	d_I\ButtonTextureID[BUTTON_RED_TEXTURE] = LoadTexture_Strict("GFX\map\textures\keypad_locked.png", 1, DeleteAllTextures)

	If opt\Atmosphere Then
		For i = BUTTON_GREEN_TEXTURE To BUTTON_RED_TEXTURE
			TextureBlend(d_I\ButtonTextureID[i], 5)
		Next
	EndIf
End Function

Const MaxLeverModelIDAmount% = 2

Type LeverInstance
	Field LeverModelID%[MaxLeverModelIDAmount]
End Type

Global lvr_I.LeverInstance

; ~ Lever Model ID Constants
;[Block]
Const LEVER_BASE_MODEL% = 0
Const LEVER_HANDLE_MODEL% = 1
;[End Block]

Function LoadLevers%()
	Local i%
	
	lvr_I.LeverInstance = New LeverInstance
	
	lvr_I\LeverModelID[LEVER_BASE_MODEL] = LoadMesh_Strict("GFX\map\Props\LeverBase.b3d")
	
	lvr_I\LeverModelID[LEVER_HANDLE_MODEL] = LoadMesh_Strict("GFX\map\Props\LeverHandle.b3d")
	
	For i = 0 To MaxLeverModelIDAmount - 1
		HideEntity(lvr_I\LeverModelID[i])
	Next
End Function

Const MaxCamModelIDAmount% = 2
Const MaxCamTextureIDAmount% = 2

Type SecurityCamInstance
	Field CamModelID%[MaxCamModelIDAmount]
	Field CamTextureID%[MaxCamTextureIDAmount]
	Field ScreenTexs%[2]
	Field SelectedMonitor.SecurityCams
	Field CoffinCam.SecurityCams
End Type

Global sc_I.SecurityCamInstance

; ~ Cam Model ID Constants
;[Block]
Const CAM_BASE_MODEL% = 0
Const CAM_HEAD_MODEL% = 1
;[End Block]

; ~ Cam Texture ID Constants
;[Block]
Const CAM_HEAD_DEFAULT_TEXTURE% = 0
Const CAM_HEAD_RED_LIGHT_TEXTURE% = 1
;[End Block]

Function LoadSecurityCams%()
	Local i%
	
	sc_I.SecurityCamInstance = New SecurityCamInstance
	
	sc_I\CamModelID[CAM_BASE_MODEL] = LoadMesh_Strict("GFX\map\Props\CamBase.b3d")
	sc_I\CamModelID[CAM_HEAD_MODEL] = LoadMesh_Strict("GFX\map\Props\CamHead.b3d")
	
	For i = 0 To MaxCamModelIDAmount - 1
		HideEntity(sc_I\CamModelID[i])
	Next
	
	For i = 0 To 1
		sc_I\ScreenTexs[i] = CreateTextureUsingCacheSystem(512, 512)
	Next
	
	For i = CAM_HEAD_DEFAULT_TEXTURE To CAM_HEAD_RED_LIGHT_TEXTURE
		sc_I\CamTextureID[i] = LoadTexture_Strict("GFX\map\textures\camera(" + (i + 1) + ").png", 1, DeleteAllTextures)
		If opt\Atmosphere Then TextureBlend(sc_I\CamTextureID[i], 5)
	Next
End Function

Const MaxMonitorModelIDAmount% = 2
Const MaxMonitorOverlayIDAmount% = 18

Type MonitorInstance
	Field MonitorModelID%[MaxMonitorModelIDAmount]
	Field MonitorOverlayID%[MaxMonitorOverlayIDAmount]
	Field MonitorTimer#, MonitorTimer2#
	Field UpdateCheckpoint1%, UpdateCheckpoint2%
End Type

Global mon_I.MonitorInstance

; ~ Monitor Model ID Constants
;[Block]
Const MONITOR_DEFAULT_MODEL% = 0
Const MONITOR_CHECKPOINT_MODEL% = 1
;[End Block]

; ~ Monitor Overlay ID Constants
;[Block]
Const MONITOR_DEFAULT_OVERLAY% = 0
Const MONITOR_LOCKDOWN_1_OVERLAY% = 1
Const MONITOR_LOCKDOWN_2_OVERLAY% = 2
Const MONITOR_LOCKDOWN_3_OVERLAY% = 3
Const MONITOR_LOCKDOWN_4_OVERLAY% = 4
Const MONITOR_079_OVERLAY_1% = 5
Const MONITOR_079_OVERLAY_2% = 6
Const MONITOR_079_OVERLAY_3% = 7
Const MONITOR_079_OVERLAY_4% = 8
Const MONITOR_079_OVERLAY_5% = 9
Const MONITOR_079_OVERLAY_6% = 10
Const MONITOR_079_OVERLAY_7% = 11
Const MONITOR_895_OVERLAY_1% = 12
Const MONITOR_895_OVERLAY_2% = 13
Const MONITOR_895_OVERLAY_3% = 14
Const MONITOR_895_OVERLAY_4% = 15
Const MONITOR_895_OVERLAY_5% = 16
Const MONITOR_895_OVERLAY_6% = 17
;[End Block]

Function LoadMonitors%()
	Local i%
	
	mon_I.MonitorInstance = New MonitorInstance
	
	mon_I\MonitorModelID[MONITOR_DEFAULT_MODEL] = LoadMesh_Strict("GFX\map\Props\monitor2.b3d")
	mon_I\MonitorModelID[MONITOR_CHECKPOINT_MODEL] = LoadMesh_Strict("GFX\map\Props\monitor_checkpoint.b3d")
	
	For i = 0 To MaxMonitorModelIDAmount - 1
		HideEntity(mon_I\MonitorModelID[i])
	Next
	
	mon_I\MonitorOverlayID[MONITOR_DEFAULT_OVERLAY] = LoadTexture_Strict("GFX\map\screens\monitor_overlay.png", 1, DeleteAllTextures)
	For i = MONITOR_LOCKDOWN_1_OVERLAY To MONITOR_LOCKDOWN_3_OVERLAY
		mon_I\MonitorOverlayID[i] = LoadTexture_Strict("GFX\map\screens\lockdown_screen(" + i + ").png", 1, DeleteAllTextures)
		If opt\Atmosphere Then TextureBlend(mon_I\MonitorOverlayID[i], 5)
	Next
	mon_I\MonitorOverlayID[MONITOR_LOCKDOWN_4_OVERLAY] = CreateTextureUsingCacheSystem(1, 1)
	SetBuffer(TextureBuffer(mon_I\MonitorOverlayID[MONITOR_LOCKDOWN_4_OVERLAY]))
	ClsColor(0, 0, 0)
	Cls()
	SetBuffer(BackBuffer())
	
	For i = MONITOR_079_OVERLAY_1 To MONITOR_079_OVERLAY_7
		mon_I\MonitorOverlayID[i] = LoadTexture_Strict("GFX\map\screens\scp_079_overlay(" + (i - 4) + ").png", 1, DeleteAllTextures)
	Next
	
	For i = MONITOR_895_OVERLAY_1 To MONITOR_895_OVERLAY_6
		mon_I\MonitorOverlayID[i] = LoadTexture_Strict("GFX\map\screens\scp_895_overlay(" + (i - 11) + ").png", 1, DeleteAllTextures)
	Next
End Function

Const MaxNPCModelIDAmount% = 32
Const MaxNPCTextureID% = 17

Type NPCInstance
	Field NPCModelID%[MaxNPCModelIDAmount]
	Field NPCTextureID%[MaxNPCTextureID]
	Field Curr173.NPCs
	Field Curr106.NPCs
	Field Curr096.NPCs
	Field Curr513_1.NPCs
	Field Curr049.NPCs
	Field IsHalloween%, IsNewYear%, IsAprilFools%
End Type

Global n_I.NPCInstance
; ~ NPC Model ID Constants
;[Block]
Const NPC_008_1_MODEL% = 0
Const NPC_035_TENTACLE_MODEL% = 1
Const NPC_049_MODEL% = 2
Const NPC_049_2_MODEL% = 3
Const NPC_066_MODEL% = 4
Const NPC_096_MODEL% = 5
Const NPC_106_MODEL% = 6
Const NPC_173_MODEL% = 7
Const NPC_173_HEAD_MODEL% = 8
Const NPC_173_BOX_MODEL% = 9
Const NPC_205_DEMON_1_MODEL% = 10
Const NPC_205_DEMON_2_MODEL% = 11
Const NPC_205_DEMON_3_MODEL% = 12
Const NPC_205_WOMAN_MODEL% = 13
Const NPC_372_MODEL% = 14
Const NPC_513_1_MODEL% = 15
Const NPC_860_2_MODEL% = 16
Const NPC_939_MODEL% = 17
Const NPC_966_MODEL% = 18
Const NPC_1048_MODEL% = 19
Const NPC_1048_A_MODEL% = 20
Const NPC_1499_1_MODEL% = 21
Const NPC_APACHE_MODEL% = 22
Const NPC_APACHE_ROTOR_1_MODEL% = 23
Const NPC_APACHE_ROTOR_2_MODEL% = 24
Const NPC_CLERK_MODEL% = 25
Const NPC_CLASS_D_MODEL% = 26
Const NPC_DUCK_MODEL% = 27
Const NPC_GUARD_MODEL% = 28
Const NPC_MTF_MODEL% = 29
Const NPC_NAZI_MODEL% = 30
Const NPC_VEHICLE_MODEL% = 31
;[End Block]

; ~ NPC Texture ID Constants
;[Block]
Const NPC_CLASS_D_GONZALES_TEXTURE% = 0
Const NPC_CLASS_D_BENJAMIN_TEXTURE% = 1
Const NPC_CLASS_D_SCIENTIST_TEXTURE% = 2
Const NPC_CLASS_D_FRANKLIN_TEXTURE% = 3
Const NPC_CLASS_D_MAYNARD_TEXTURE% = 4
Const NPC_CLASS_D_CLASS_D_TEXTURE% = 5
Const NPC_CLASS_D_D9341_TEXTURE% = 6
Const NPC_CLASS_D_BODY_1_TEXTURE% = 7
Const NPC_CLASS_D_BODY_2_TEXTURE% = 8
Const NPC_CLASS_D_JANITOR_1_TEXTURE% = 9
Const NPC_CLASS_D_JANITOR_2_TEXTURE% = 10
Const NPC_CLASS_D_VICTIM_008_TEXTURE% = 11
Const NPC_CLASS_D_VICTIM_035_TEXTURE% = 12
Const NPC_CLASS_D_VICTIM_409_TEXTURE% = 13
Const NPC_CLASS_D_VICTIM_939_1_TEXTURE% = 14
Const NPC_CLASS_D_VICTIM_939_2_TEXTURE% = 15

Const NPC_096_BLOODY_TEXTURE% = 16
;[End Block]

Function LoadNPCs%()
	Local i%
	
	n_I.NPCInstance = New NPCInstance
	
	n_I\NPCModelID[NPC_008_1_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_008_1.b3d")
	
	n_I\NPCModelID[NPC_035_TENTACLE_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_035_tentacle.b3d")
	
	n_I\NPCModelID[NPC_049_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_049.b3d")
	
	n_I\NPCModelID[NPC_049_2_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_049_2.b3d")
	
	n_I\NPCModelID[NPC_066_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_066.b3d")
	
	n_I\NPCModelID[NPC_096_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_096.b3d")
	
	n_I\NPCModelID[NPC_106_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_106.b3d")
	
	n_I\NPCModelID[NPC_173_MODEL] = LoadMesh_Strict("GFX\npcs\scps\scp_173_body.b3d")
	n_I\NPCModelID[NPC_173_HEAD_MODEL] = LoadMesh_Strict("GFX\npcs\scps\scp_173_head.b3d")
	n_I\NPCModelID[NPC_173_BOX_MODEL] = LoadMesh_Strict("GFX\npcs\scps\scp_173_box.b3d")
	
	n_I\NPCModelID[NPC_205_DEMON_1_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_205_demon.b3d")
	n_I\NPCModelID[NPC_205_DEMON_2_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_205_demon(2).b3d")
	n_I\NPCModelID[NPC_205_DEMON_3_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_205_demon(3).b3d")
	n_I\NPCModelID[NPC_205_WOMAN_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_205_woman.b3d")
	
	n_I\NPCModelID[NPC_372_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_372.b3d")
	
	n_I\NPCModelID[NPC_513_1_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_513_1.b3d")
	
	n_I\NPCModelID[NPC_860_2_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_860_2.b3d")
	
	n_I\NPCModelID[NPC_939_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_939.b3d")
	
	n_I\NPCModelID[NPC_966_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_966.b3d")
	
	n_I\NPCModelID[NPC_1048_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_1048.b3d")
	n_I\NPCModelID[NPC_1048_A_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_1048_a.b3d")
	
	n_I\NPCModelID[NPC_1499_1_MODEL] = LoadAnimMesh_Strict("GFX\npcs\scps\scp_1499_1.b3d")
	
	n_I\NPCModelID[NPC_APACHE_MODEL] = LoadAnimMesh_Strict("GFX\npcs\apache.b3d")
	n_I\NPCModelID[NPC_APACHE_ROTOR_1_MODEL] = LoadAnimMesh_Strict("GFX\npcs\apache_rotor.b3d")
	n_I\NPCModelID[NPC_APACHE_ROTOR_2_MODEL] = LoadAnimMesh_Strict("GFX\npcs\apache_rotor(2).b3d")
	
	n_I\NPCModelID[NPC_CLERK_MODEL] = LoadAnimMesh_Strict("GFX\npcs\humans\clerk.b3d")
	
	n_I\NPCModelID[NPC_CLASS_D_MODEL] = LoadAnimMesh_Strict("GFX\npcs\humans\class_d.b3d")
	
	n_I\NPCModelID[NPC_DUCK_MODEL] = LoadAnimMesh_Strict("GFX\npcs\duck.b3d")
	
	n_I\NPCModelID[NPC_GUARD_MODEL] = LoadAnimMesh_Strict("GFX\npcs\humans\guard.b3d")
	
	n_I\NPCModelID[NPC_MTF_MODEL] = LoadAnimMesh_Strict("GFX\npcs\humans\MTF.b3d")
	
	n_I\NPCModelID[NPC_NAZI_MODEL] = LoadAnimMesh_Strict("GFX\npcs\humans\nazi_officer.b3d")
	
	n_I\NPCModelID[NPC_VEHICLE_MODEL] = LoadAnimMesh_Strict("GFX\npcs\vehicle.b3d")
	
	For i = 0 To MaxNPCModelIDAmount - 1
		HideEntity(n_I\NPCModelID[i])
	Next
	
	n_I\NPCTextureID[NPC_CLASS_D_GONZALES_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\Gonzales.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_BENJAMIN_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\D_9341(2).png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_SCIENTIST_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\Bergman.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_FRANKLIN_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\Franklin.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_MAYNARD_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\Maynard.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_CLASS_D_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\class_d(2).png", 1, DeleteAllTextures)
	If opt\IntroEnabled Then n_I\NPCTextureID[NPC_CLASS_D_D9341_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\D_9341.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_BODY_1_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\Delgado.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_BODY_2_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\body(2).png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_JANITOR_1_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\Feraud.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_JANITOR_2_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\Rojas.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_VICTIM_008_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\scp_008_1_Pascal.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_VICTIM_035_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\scp_035_Nikolay.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_VICTIM_409_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\scp_409_victim.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_VICTIM_939_1_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\scp_939_victim.png", 1, DeleteAllTextures)
	n_I\NPCTextureID[NPC_CLASS_D_VICTIM_939_2_TEXTURE] = LoadTexture_Strict("GFX\npcs\humans\scp_939_victim(2).png", 1, DeleteAllTextures)
	
	n_I\NPCTextureID[NPC_096_BLOODY_TEXTURE] = LoadTexture_Strict("GFX\npcs\scps\scp_096_bloody.png", 1, DeleteAllTextures)

	If opt\Atmosphere Then
		For i = NPC_CLASS_D_GONZALES_TEXTURE To NPC_096_BLOODY_TEXTURE
			Local Skip% = False

			If (Not opt\IntroEnabled) And i = NPC_CLASS_D_D9341_TEXTURE Then Skip = True
			If (Not Skip) Then TextureBlend(n_I\NPCTextureID[i], 5)
		Next
	EndIf
End Function

Const MaxMTModelIDAmount% = 7
Const MaxLightSpriteIDAmount% = 3

Type MiscInstance
	Field MTModelID%[MaxMTModelIDAmount]
	Field CupLiquid%
	Field LightSpriteID[MaxLightSpriteIDAmount]
	Field AdvancedLightSprite%
End Type

Global misc_I.MiscInstance

; ~ Light Sprite ID Constants
;[Block]
Const LIGHT_SPRITE_DEFAULT% = 0
Const LIGHT_SPRITE_RED% = 1
;[End Block]

; ~ MT Model ID Constants
;[Block]
Const MT_ROOM1% = 0
Const MT_ROOM2% = 1
Const MT_ROOM2C% = 2
Const MT_ROOM3% = 3
Const MT_ROOM4% = 4
Const MT_ELEVATOR% = 5
Const MT_GENERATOR% = 6
;[End Block]

Function LoadMisc%()
	Local i%
	
	misc_I.MiscInstance = New MiscInstance
	
	misc_I\MTModelID[MT_ROOM1] = LoadRMesh("GFX\map\hcz\mt1.rmesh", Null)
	misc_I\MTModelID[MT_ROOM2] = LoadRMesh("GFX\map\hcz\mt2.rmesh", Null)
	misc_I\MTModelID[MT_ROOM2C] = LoadRMesh("GFX\map\hcz\mt2C.rmesh", Null)
	misc_I\MTModelID[MT_ROOM3] = LoadRMesh("GFX\map\hcz\mt3.rmesh", Null)
	misc_I\MTModelID[MT_ROOM4] = LoadRMesh("GFX\map\hcz\mt4.rmesh", Null)
	misc_I\MTModelID[MT_ELEVATOR] = LoadRMesh("GFX\map\hcz\mt_elevator.rmesh", Null)
	misc_I\MTModelID[MT_GENERATOR] = LoadRMesh("GFX\map\hcz\mt_generator.rmesh", Null)
	
	For i = 0 To MaxMTModelIDAmount - 1
		HideEntity(misc_I\MTModelID[i])
	Next
	
	misc_I\CupLiquid = LoadMesh_Strict("GFX\items\cup_liquid.b3d")
	HideEntity(misc_I\CupLiquid)
	
	For i = LIGHT_SPRITE_DEFAULT To LIGHT_SPRITE_RED
		misc_I\LightSpriteID[i] = LoadTexture_Strict("GFX\light(" + i + ").png", 1, DeleteAllTextures)
	Next
	misc_I\AdvancedLightSprite = LoadTexture_Strict("GFX\advanced_light.png", 1, DeleteAllTextures)
End Function

Function LoadMaterials%(File$)
	CatchErrors("Uncaught (LoadMaterials)")
	
	Local TemporaryString$
	Local mat.Materials = Null
	Local StrTemp$ = ""
	Local f% = OpenFile(File)
	
	While (Not Eof(f))
		TemporaryString = Trim(ReadLine(f))
		If Left(TemporaryString, 1) = "[" Then
			TemporaryString = Mid(TemporaryString, 2, Len(TemporaryString) - 2)
			mat.Materials = New Materials
			mat\Name = Lower(TemporaryString)
			If opt\BumpEnabled Then
				StrTemp = GetINIString(File, TemporaryString, "bump")
				If StrTemp <> "" Then 
					mat\Bump =  LoadTexture_Strict(StrTemp, 256)
					ApplyBumpMap(mat\Bump)
				EndIf
			EndIf
			mat\StepSound = (GetINIInt(File, TemporaryString, "stepsound") + 1)
			mat\IsDiffuseAlpha = GetINIInt(File, TemporaryString, "transparent")
			mat\UseMask = GetINIInt(File, TemporaryString, "masked")
		EndIf
	Wend
	
	CloseFile(f)
	
	CatchErrors("LoadMaterials")
End Function

Const ItemsPath$ = "GFX\items\"
Const INVPath$ = "GFX\items\inventory\"
Const CardPath$ = "GFX\items\cards\"
Const DocPath$ = "GFX\items\docs\"
Const NotePath$ = "GFX\items\notes\"

Function LoadItems%()
	Local it.ItemTemplates, it2.ItemTemplates
	
	; ~ [PAPER]
	
	CreateItemTemplate("Document SCP-005", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_005.png", 0.003, 0)
	CreateItemTemplate("Document SCP-006", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_006.png", 0.003, 0)
	CreateItemTemplate("Document SCP-008", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_008.png", 0.003, 0)
	CreateItemTemplate("Document SCP-012", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_012.png", 0.003, 0)
	CreateItemTemplate("Document SCP-035", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_035_smile.png", 0.003, 0)
	CreateItemTemplate("Document SCP-049", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_049.png", 0.003, 0)
	CreateItemTemplate("Document SCP-079", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_079.png", 0.003, 0)
	CreateItemTemplate("Document SCP-096", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_096.png", 0.003, 0)
	CreateItemTemplate("Document SCP-106", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_106.png", 0.003, 0)
	CreateItemTemplate("Document SCP-173", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_173.png", 0.003, 0)
	CreateItemTemplate("Janitorial Document SCP-173", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_173_intro.png", 0.003, 0)
	CreateItemTemplate("Document SCP-205", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_205.png", 0.003, 0)
	CreateItemTemplate("Document SCP-268", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_268.png", 0.003, 0)
	CreateItemTemplate("Document SCP-372", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_372.png", 0.003, 0)
	CreateItemTemplate("Document SCP-409", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_409.png", 0.003, 0)
	CreateItemTemplate("Document SCP-500", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_500.png", 0.003, 0)
	CreateItemTemplate("Document SCP-513", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_513.png", 0.003, 0)
	CreateItemTemplate("Document SCP-682", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_682.png", 0.003, 0)
	CreateItemTemplate("Document SCP-714", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_714.png", 0.003, 0)
	CreateItemTemplate("Document SCP-860", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_860.png", 0.003, 0)
	CreateItemTemplate("Document SCP-860-1", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_860_1.png", 0.003, 0)
	CreateItemTemplate("Document SCP-895", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_895.png", 0.003, 0)
	CreateItemTemplate("Document SCP-914", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_914.png", 0.003, 0)
	CreateItemTemplate("Document SCP-939", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_939.png", 0.003, 0)
	CreateItemTemplate("Document SCP-966", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_966.png", 0.003, 0)
	CreateItemTemplate("Document SCP-970", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_970.png", 0.003, 0)
	CreateItemTemplate("Document SCP-1048", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_1048.png", 0.003, 0)
	CreateItemTemplate("Document SCP-1123", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_1123.png", 0.003, 0)
	CreateItemTemplate("Document SCP-1162-ARC", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_1162_ARC.png", 0.003, 0)
	CreateItemTemplate("Document SCP-1499", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_1499.png", 0.003, 0)
	
	CreateItemTemplate("Incident Report SCP-1048-A", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_IR_1048_a.png", 0.003, 0)
	
	CreateItemTemplate("SCP-035 Addendum", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_035_ad.png", 0.003, 0)
	
	CreateItemTemplate("SCP-093 Recovered Materials", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_093_rm.png", 0.003, 0)
	
	CreateItemTemplate("Addendum: 5/14 Test Log", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_RAND(2).png", 0.003, 0)
	
	CreateItemTemplate("Class D Orientation Leaflet", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_OL.png", 0.003, 0)
	
	CreateItemTemplate("Disciplinary Hearing DH-S-4137-17092", "oldpaper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_DH.png", 0.003, 0)
	
	CreateItemTemplate("Document", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_RAND(3).png", 0.003, 0)
	
	CreateItemTemplate("Field Agent Log #235-001-CO5", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_O5.png", 0.003, 0)
	
	CreateItemTemplate("Groups of Interest Log", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_O5(2).png", 0.003, 0)
	
	CreateItemTemplate("Incident Report SCP-106-0204", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_IR_106.png", 0.003, 0)
	
	CreateItemTemplate("Mobile Task Forces", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_MTF.png", 0.003, 0)
	
	CreateItemTemplate("Note from Daniel", "paper", NotePath + "note.b3d", INVPath + "INV_note(2).png", NotePath + "note_Daniel.png", 0.0025, 0)
	
	CreateItemTemplate("Nuclear Device Document", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_NDP.png", 0.003, 0)
	
	CreateItemTemplate("Object Classes", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_OBJC.png", 0.003, 0)
	
	CreateItemTemplate("Recall Protocol RP-106-N", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_RP.png", 0.0025, 0)
	
	CreateItemTemplate("Research Sector-02 Scheme", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_RS.png", 0.003, 0)
	
	CreateItemTemplate("Security Clearance Levels", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_SCL.png", 0.003, 0)
	
	CreateItemTemplate("Sticky Note", "paper", NotePath + "note.b3d", INVPath + "INV_note(2).png", NotePath + "note_682.png", 0.0025, 0)
	
	CreateItemTemplate("The Modular Site Project", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper.png", DocPath + "doc_MSP.png", 0.003, 0)
	
	CreateItemTemplate("Blank Paper", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper_blank.png", DocPath + "doc_blank.png", 0.003, 0, ItemsPath + "paper_blank.png")
	
	CreateItemTemplate("Blood-stained Note", "paper", NotePath + "note.b3d", INVPath + "INV_note_bloody.png", NotePath + "note_L(3).png", 0.0025, 0, NotePath + "note_bloody.png")
	
	it.ItemTemplates = CreateItemTemplate("Burnt Note", "paper", ItemsPath + "paper.b3d", INVPath + "INV_burnt_note.png", NotePath + "note_Maynard.png", 0.003, 0, NotePath + "burnt_note.png")
	it\Img = BurntNote
	
	CreateItemTemplate("Data Report", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper_bloody.png", DocPath + "doc_data.png", 0.003, 0, ItemsPath + "paper_bloody.png")
	
	CreateItemTemplate("Document SCP-427", "paper", ItemsPath + "paper.b3d", INVPath + "INV_paper_bloody.png", DocPath + "doc_427.png", 0.003, 0, ItemsPath + "paper_bloody.png")
	
	CreateItemTemplate("Drawing", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", DocPath + "doc_1048.png", 0.003, 0, NotePath + "note.png")
	
	CreateItemTemplate("Dr. Allok's Note", "paper", NotePath + "note.b3d", INVPath + "INV_note.png", NotePath + "note_Allok.png", 0.004, 0, NotePath + "note.png")
	
	CreateItemTemplate("Dr. L's Note #1", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", NotePath + "note_L.png", 0.0025, 0, NotePath + "note.png")
	CreateItemTemplate("Dr. L's Note #2", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", NotePath + "note_L(2).png", 0.0025, 0, NotePath + "note.png")
	
	CreateItemTemplate("Dr. L's Burnt Note #1", "paper", ItemsPath + "paper.b3d", INVPath + "INV_burnt_note.png", NotePath + "note_L(4).png", 0.0025, 0, NotePath + "burnt_note.png")
	CreateItemTemplate("Dr. L's Burnt Note #2", "paper", ItemsPath + "paper.b3d", INVPath + "INV_burnt_note.png", NotePath + "note_L(5).png", 0.0025, 0, NotePath + "burnt_note.png")
	
	CreateItemTemplate("L.S.'s Note", "paper", NotePath + "note.b3d", INVPath + "INV_note(2).png", NotePath + "note_LS.png", 0.0025, 0)
	CreateItemTemplate("L.S.'s Note #2", "paper", NotePath + "note.b3d", INVPath + "INV_note(2).png", NotePath + "note_LS(2).png", 0.0025, 0)
	CreateItemTemplate("L.S.'s Drawing", "paper", NotePath + "note.b3d", INVPath + "INV_note.png", NotePath + "drawing_LS.png", 0.0025, 0, NotePath + "note.png")
	
	CreateItemTemplate("Emily Ross' Badge", "badge", ItemsPath + "badge.b3d", INVPath + "INV_Emily_badge.png", ItemsPath + "Emily_badge_HUD.png", 0.0001, 1, ItemsPath + "Emily_badge.png")
	
	CreateItemTemplate("Journal Page", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", NotePath + "note_Gonzales.png", 0.0025, 0, NotePath + "note.png")
	
	CreateItemTemplate("Leaflet", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", ItemsPath + "leaflet.png", 0.003, 0, NotePath + "note.png")
	
	CreateItemTemplate("Log #1", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", NotePath + "note_forest.png", 0.002, 0, NotePath + "note.png")
	CreateItemTemplate("Log #2", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", NotePath + "note_forest(2).png", 0.002, 0, NotePath + "note.png")
	CreateItemTemplate("Log #3", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", NotePath + "note_forest(3).png", 0.002, 0, NotePath + "note.png")
	
	CreateItemTemplate("Movie Ticket", "ticket", ItemsPath + "badge.b3d", INVPath + "INV_ticket.png", ItemsPath + "ticket_HUD.png", 0.0001, 0, ItemsPath + "ticket.png", "", 0, 1 + 2 + 8)
	
	CreateItemTemplate("Mysterious Note", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", NotePath + "note_mysterious.png", 0.003, 0, NotePath + "note.png")
	
	CreateItemTemplate("Note from Maynard", "paper", NotePath + "note.b3d", INVPath + "INV_note.png", NotePath + "note_Maynard(2).png", 0.0025, 0, NotePath + "note.png")
	
	CreateItemTemplate("Notification", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", DocPath + "doc_RAND.png", 0.003, 0, NotePath + "note.png")
	
	CreateItemTemplate("Old Badge", "badge", ItemsPath + "badge.b3d", INVPath + "INV_D_9341_badge.png", ItemsPath + "D_9341_badge_HUD.png", 0.0001, 1, ItemsPath + "D_9341_badge.png", "", 0, 1 + 2 + 8)
	
	CreateItemTemplate("Origami", "origami", ItemsPath + "origami.b3d", INVPath + "INV_origami.png", "", 0.003, 0)
	
	CreateItemTemplate("Scorched Note", "paper", ItemsPath + "paper.b3d", INVPath + "INV_burnt_note.png", NotePath + "note_L(6).png", 0.0025, 0, NotePath + "burnt_note.png")
	
	CreateItemTemplate("Strange Note", "paper", ItemsPath + "paper.b3d", INVPath + "INV_note.png", NotePath + "note_strange.png", 0.0025, 0, NotePath + "note.png")
	
	CreateItemTemplate("Unknown Note", "paper", NotePath + "note.b3d", INVPath + "INV_note_bloody.png", NotePath + "note_unknown.png", 0.003, 0, NotePath + "note_bloody.png")
	
	; ~ [SCPs]
	
	CreateItemTemplate("SCP-005", "scp005", ItemsPath + "scps\scp_005.b3d", INVPath + "INV_scp_005.png", "", 0.0004, 1)
	CreateItemTemplate("SCP-148 Ingot", "scp148ingot", ItemsPath + "scps\scp_148.b3d", INVPath + "INV_scp_148.png", "", RoomScale, 2)
	CreateItemTemplate("SCP-427", "scp427", ItemsPath + "scps\scp_427.b3d", INVPath + "INV_scp_427.png", "", 0.001, 3)
	
	it.ItemTemplates = CreateItemTemplate("SCP-500-01", "scp500pill", ItemsPath + "scps\pill.b3d", INVPath + "INV_scp_500_pill.png", "", 0.0001, 2)
	EntityColor(it\OBJ, 255.0, 0.0, 0.0)
	
	it.ItemTemplates = CreateItemTemplate("SCP-2022-01", "scp2022pill", ItemsPath + "scps\pill.b3d", INVPath + "INV_scp_2022_pill.png", "", 0.0001, 2)
	EntityColor(it\OBJ, 224.0, 160.0, 0.0)
	
	CreateItemTemplate("SCP-500", "scp500", ItemsPath + "scps\scp_500.b3d", INVPath + "INV_scp_500.png", "", 0.035, 2)
	CreateItemTemplate("SCP-513", "scp513", ItemsPath + "scps\scp_513.b3d", INVPath + "INV_scp_513.png", "", 0.1, 2)
	CreateItemTemplate("SCP-714", "scp714", ItemsPath + "scps\scp_714.b3d", INVPath + "INV_scp_714.png", "", 0.3, 3)
	CreateItemTemplate("Sapphire Ring", "kill714", ItemsPath + "scps\scp_714.b3d", INVPath + "INV_scp_714_blue.png", "", 0.3, 3, ItemsPath + "scps\scp_714_blue.png", "", 1)
	CreateItemTemplate("Augelite Ring", "coarse714", ItemsPath + "scps\scp_714.b3d", INVPath + "INV_scp_714_grey.png", "", 0.3, 3, ItemsPath + "scps\scp_714_grey.png", "", 1)
	CreateItemTemplate("SCP-860", "scp860", ItemsPath + "scps\scp_860.b3d", INVPath + "INV_scp_860.png", "", 0.003, 3)
	CreateItemTemplate("SCP-1025", "scp1025", ItemsPath + "scps\scp_1025.b3d", INVPath + "INV_scp_1025.png", "", 0.1, 0)
	CreateItemTemplate("SCP-1123", "scp1123", ItemsPath + "scps\scp_1123.b3d", INVPath + "INV_scp_1123.png", "", 0.015, 2)
	CreateItemTemplate("SCP-268", "scp268", ItemsPath + "scps\scp_268.b3d", INVPath + "INV_scp_268.png", "", 0.09, 2)
	CreateItemTemplate("SCP-268", "super268", ItemsPath + "scps\scp_268.b3d", INVPath + "INV_scp_268.png", "", 0.09, 2)
	CreateItemTemplate("Newsboy Cap", "cap", ItemsPath + "scps\scp_268.b3d", INVPath + "INV_scp_268.png", "", 0.09, 2)
	CreateItemTemplate("SCP-1499", "scp1499", ItemsPath + "scps\scp_1499.b3d", INVPath + "INV_scp_1499.png", "", 0.022, 2)
	CreateItemTemplate("SCP-1499", "super1499", ItemsPath + "scps\scp_1499.b3d", INVPath + "INV_scp_1499.png", "", 0.022, 2)
	
	CreateItemTemplate("Joint", "joint", ItemsPath + "scps\scp_420_j.b3d", INVPath + "INV_scp_420_j.png", "", 0.0004, 2)
	
	CreateItemTemplate("Blue Key", "bluekey", ItemsPath + "scps\scp_860.b3d", INVPath + "INV_scp_860.png", "", 0.003, 3)
	
	CreateItemTemplate("Metal Panel", "scp148", ItemsPath + "scps\metal_panel.b3d", INVPath + "INV_metal_panel.png", "", RoomScale, 2)
	
	CreateItemTemplate("Smelly Joint", "scp420s", ItemsPath + "scps\scp_420_j.b3d", INVPath + "INV_scp_420_j.png", "", 0.0004, 2)
	
	CreateItemTemplate("Some SCP-420-J", "scp420j", ItemsPath + "scps\scp_420_j.b3d", INVPath + "INV_scp_420_j.png", "", 0.0005, 2)
	
	it.ItemTemplates = CreateItemTemplate("Upgraded Pill", "scp500pilldeath", ItemsPath + "scps\pill.b3d", INVPath + "INV_scp_500_pill.png", "", 0.0001, 2)
	EntityColor(it\OBJ, 255.0, 0.0, 0.0)
	
	; ~ [MISC ITEMS]
	
	CreateItemTemplate("Ballistic Helmet", "helmet", ItemsPath + "ballistic_helmet.b3d", INVPath + "INV_ballistic_helmet.png", "", 0.018, 2)
	
	CreateItemTemplate("Ballistic Vest", "vest", ItemsPath + "ballistic_vest.b3d", INVPath + "INV_ballistic_vest.png", "", 0.02, 2)
	CreateItemTemplate("Bulky Ballistic Vest", "veryfinevest", ItemsPath + "ballistic_vest.b3d", INVPath + "INV_ballistic_vest.png", "", 0.025, 2)
	CreateItemTemplate("Heavy Ballistic Vest", "finevest", ItemsPath + "ballistic_vest.b3d", INVPath + "INV_ballistic_vest.png", "", 0.022, 2)
	CreateItemTemplate("Corrosive Ballistic Vest", "corrvest", ItemsPath + "ballistic_vest.b3d", INVPath + "INV_ballistic_vest.png", "", 0.02, 2, ItemsPath + "ballistic_vest_corrosive.png")
	
	CreateItemTemplate("Book", "book", ItemsPath + "scps\scp_1025.b3d", INVPath + "INV_book.png", "", 0.07, 0, ItemsPath + "book.png")
	
	CreateItemTemplate("Cigarette", "cigarette", ItemsPath + "scps\scp_420_j.b3d", INVPath + "INV_scp_420_j.png", "", 0.0004, 2)
	
	CreateItemTemplate("Cup", "cup", ItemsPath + "cup.b3d", INVPath + "INV_cup.png", "", 0.04, 2)
	
	CreateItemTemplate("Clipboard", "clipboard", ItemsPath + "clipboard.b3d", INVPath + "INV_clipboard.png", "", 0.003, 1, "", INVPath + "INV_clipboard(2).png", 1)
	
	CreateItemTemplate("Electronical Components", "electronics", ItemsPath + "circuits.b3d", INVPath + "INV_circuits.png", "", 0.0011, 1)
	
	CreateItemTemplate("Empty Cup", "emptycup", ItemsPath + "cup.b3d", INVPath + "INV_cup.png", "", 0.04, 2)
	
	CreateItemTemplate("ReVision Eyedrops", "eyedrops", ItemsPath + "eye_drops.b3d", INVPath + "INV_eye_drops.png", "", 0.0012, 1)
	CreateItemTemplate("Eyedrops", "fineeyedrops", ItemsPath + "eye_drops.b3d", INVPath + "INV_eye_drops.png", "", 0.0012, 1)
	CreateItemTemplate("Eyedrops", "supereyedrops", ItemsPath + "eye_drops.b3d", INVPath + "INV_eye_drops.png", "", 0.0012, 1)
	CreateItemTemplate("RedVision Eyedrops", "redeyedrops", ItemsPath + "eye_drops.b3d", INVPath + "INV_eye_drops_red.png", "", 0.0012, 1, ItemsPath + "eye_drops_red.png")
	
	CreateItemTemplate("First Aid Kit", "firstaid", ItemsPath + "first_aid_kit.b3d", INVPath + "INV_first_aid_kit.png", "", 0.05, 1)
	CreateItemTemplate("Compact First Aid Kit", "finefirstaid", ItemsPath + "first_aid_kit.b3d", INVPath + "INV_first_aid_kit.png", "", 0.03, 1)
	CreateItemTemplate("Blue First Aid Kit", "bluefirstaid", ItemsPath + "first_aid_kit.b3d", INVPath + "INV_first_aid_kit(2).png", "", 0.03, 1, ItemsPath + "first_aid_kit(2).png")
	CreateItemTemplate("Strange Bottle", "veryfinefirstaid", ItemsPath + "eye_drops.b3d", INVPath + "INV_strange_bottle.png", "", 0.002, 1, ItemsPath + "strange_bottle.png")	
	
	CreateItemTemplate("Gas Mask", "gasmask", ItemsPath + "gas_mask.b3d", INVPath + "INV_gas_mask.png", "", 0.019, 2)
	CreateItemTemplate("Gas Mask", "finegasmask", ItemsPath + "gas_mask.b3d", INVPath + "INV_gas_mask.png", "", 0.019, 2)
	CreateItemTemplate("Gas Mask", "supergasmask", ItemsPath + "gas_mask.b3d", INVPath + "INV_gas_mask.png", "", 0.02, 2)
	CreateItemTemplate("Heavy Gas Mask", "heavygasmask", ItemsPath + "gas_mask.b3d", INVPath + "INV_gas_mask_heavy.png", "", 0.02, 2, ItemsPath + "gas_mask_heavy.png", "", 1)
	
	CreateItemTemplate("Hazmat Suit", "hazmatsuit", ItemsPath + "hazmat_suit.b3d", INVPath + "INV_hazmat_suit.png", "", 0.013, 2, "", "", 1)
	CreateItemTemplate("Hazmat Suit", "finehazmatsuit", ItemsPath + "hazmat_suit.b3d", INVPath + "INV_hazmat_suit.png", "", 0.013, 2, "", "", 1)
	CreateItemTemplate("Hazmat Suit", "superhazmatsuit", ItemsPath + "hazmat_suit.b3d", INVPath + "INV_hazmat_suit.png", "", 0.013, 2, "", "", 1)
	CreateItemTemplate("Heavy Hazmat Suit", "heavyhazmatsuit", ItemsPath + "hazmat_suit.b3d", INVPath + "INV_hazmat_suit_heavy.png", "", 0.013, 2, ItemsPath + "hazmat_suit_heavy.png", "", 1)
	
	CreateItemTemplate("Night Vision Goggles", "nvg", ItemsPath + "night_vision_goggles.b3d", INVPath + "INV_night_vision_goggles.png", "", 0.02, 2)
	CreateItemTemplate("Night Vision Goggles", "finenvg", ItemsPath + "night_vision_goggles.b3d", INVPath + "INV_night_vision_goggles(2).png", "", 0.02, 2)
	CreateItemTemplate("Night Vision Goggles", "supernvg", ItemsPath + "night_vision_goggles.b3d", INVPath + "INV_night_vision_goggles(3).png", "", 0.02, 2)
	CreateItemTemplate("SCRAMBLE Gear", "scramble", ItemsPath + "SCRAMBLE_gear.b3d", INVPath + "INV_SCRAMBLE_gear.png", "", 0.02, 2)
	CreateItemTemplate("SCRAMBLE Gear", "finescramble", ItemsPath + "SCRAMBLE_gear.b3d", INVPath + "INV_SCRAMBLE_gear.png", "", 0.02, 2)
	CreateItemTemplate("SCRAMBLE Gear", "killscramble", ItemsPath + "SCRAMBLE_gear.b3d", INVPath + "INV_SCRAMBLE_gear.png", "", 0.02, 2)
	
	it.ItemTemplates = CreateItemTemplate("Pill", "pill", ItemsPath + "scps\pill.b3d", INVPath + "INV_pill.png", "", 0.0001, 2)
	EntityColor(it\OBJ, 255.0, 255.0, 255.0)
	
	CreateItemTemplate("Green Jade Ring", "ring", ItemsPath + "scps\scp_714.b3d", INVPath + "INV_scp_714.png", "", 0.2, 3)
	
	CreateItemTemplate("Radio Transceiver", "radio", ItemsPath + "radio.b3d", INVPath + "INV_radio.png", ItemsPath + "radio_HUD.png", 1.0, 1)
	CreateItemTemplate("Radio Transceiver", "fineradio", ItemsPath + "radio.b3d", INVPath + "INV_radio.png", ItemsPath + "radio_HUD.png", 1.0, 1)
	CreateItemTemplate("Radio Transceiver", "veryfineradio", ItemsPath + "radio.b3d", INVPath + "INV_radio.png", ItemsPath + "radio_HUD.png", 1.0, 1)
	CreateItemTemplate("Radio Transceiver", "18vradio", ItemsPath + "radio.b3d", INVPath + "INV_radio.png", ItemsPath + "radio_HUD.png", 1.02, 1)
	
	CreateItemTemplate("White Severed Hand", "hand", ItemsPath + "severed_hand.b3d", INVPath + "INV_severed_hand(1).png", "", 0.03, 2)
	CreateItemTemplate("Black Severed Hand", "hand2", ItemsPath + "severed_hand.b3d", INVPath + "INV_severed_hand(2).png", "", 0.03, 2, ItemsPath + "severed_hand(2).png")
	
	CreateItemTemplate("S-NAV Navigator", "nav", ItemsPath + "navigator.b3d", INVPath + "INV_navigator.png", ItemsPath + "navigator_HUD.png", 0.0008, 1)
	CreateItemTemplate("S-NAV Navigator Ultimate", "navulti", ItemsPath + "navigator.b3d", INVPath + "INV_navigator.png", ItemsPath + "navigator_HUD.png", 0.0008, 1)
	CreateItemTemplate("S-NAV 300 Navigator", "nav300", ItemsPath + "navigator.b3d", INVPath + "INV_navigator.png", ItemsPath + "navigator_HUD.png", 0.0008, 1)
	CreateItemTemplate("S-NAV 310 Navigator", "nav310", ItemsPath + "navigator.b3d", INVPath + "INV_navigator.png", ItemsPath + "navigator_HUD.png", 0.0008, 1)
	
	CreateItemTemplate("9V Battery", "bat", ItemsPath + "battery.b3d", INVPath + "INV_battery_9v.png", "", 0.008, 1)
	CreateItemTemplate("4.5V Battery", "coarsebat", ItemsPath + "battery.b3d", INVPath + "INV_battery_4.5v.png", "", 0.008, 1, ItemsPath + "battery_4.5V.png")
	CreateItemTemplate("18V Battery", "finebat", ItemsPath + "battery.b3d", INVPath + "INV_battery_18v.png", "", 0.01, 1, ItemsPath + "battery_18V.png")
	CreateItemTemplate("999V Battery", "superbat", ItemsPath + "battery.b3d", INVPath + "INV_battery_999v.png", "", 0.009, 1, ItemsPath + "battery_999V.png")
	CreateItemTemplate("Strange Battery", "killbat", ItemsPath + "battery.b3d", INVPath + "INV_strange_battery.png", "", 0.01, 1, ItemsPath + "strange_battery.png")
	
	CreateItemTemplate("Syringe", "syringe", ItemsPath + "syringe.b3d", INVPath + "INV_syringe.png", "", 0.005, 2)
	CreateItemTemplate("Syringe", "finesyringe", ItemsPath + "syringe.b3d", INVPath + "INV_syringe.png", "", 0.005, 2)
	CreateItemTemplate("Syringe", "veryfinesyringe", ItemsPath + "syringe.b3d", INVPath + "INV_syringe.png", "", 0.005, 2)
	CreateItemTemplate("Syringe", "syringeinf", ItemsPath + "syringe.b3d", INVPath + "INV_syringe_infect.png", "", 0.005, 2, ItemsPath + "syringe_infect.png")
	
	CreateItemTemplate("Wallet", "wallet", ItemsPath + "wallet.b3d", INVPath + "INV_wallet.png", "", 0.0006, 2, "", "", 1)
	
	; ~ [KEYCARDS, KEYS, CARDS, COINS]
	
	CreateItemTemplate("Level 0 Key Card", "key0", CardPath + "key_card.b3d", INVPath + "INV_key_card_lvl_0.png", "", 0.0004, 1, CardPath + "key_card_lvl_0.png")
	CreateItemTemplate("Level 1 Key Card", "key1", CardPath + "key_card.b3d", INVPath + "INV_key_card_lvl_1.png", "", 0.0004, 1, CardPath + "key_card_lvl_1.png")
	CreateItemTemplate("Level 2 Key Card", "key2", CardPath + "key_card.b3d", INVPath + "INV_key_card_lvl_2.png", "", 0.0004, 1, CardPath + "key_card_lvl_2.png")
	CreateItemTemplate("Level 3 Key Card", "key3", CardPath + "key_card.b3d", INVPath + "INV_key_card_lvl_3.png", "", 0.0004, 1, CardPath + "key_card_lvl_3.png")
	CreateItemTemplate("Level 4 Key Card", "key4", CardPath + "key_card.b3d", INVPath + "INV_key_card_lvl_4.png", "", 0.0004, 1, CardPath + "key_card_lvl_4.png")
	CreateItemTemplate("Level 5 Key Card", "key5", CardPath + "key_card.b3d", INVPath + "INV_key_card_lvl_5.png", "", 0.0004, 1, CardPath + "key_card_lvl_5.png")
	CreateItemTemplate("Level 6 Key Card", "key6", CardPath + "key_card.b3d", INVPath + "INV_key_card_lvl_6.png", "", 0.0004, 1, CardPath + "key_card_lvl_6.png")
	CreateItemTemplate("Key Card Omni", "keyomni", CardPath + "key_card.b3d", INVPath + "INV_key_card_lvl_omni.png", "", 0.0004, 1, CardPath + "key_card_lvl_omni.png")
	
	CreateItemTemplate("Lost Key", "key", ItemsPath + "key.b3d", INVPath + "INV_key.png", "", 0.003, 3)
	
	CreateItemTemplate("Mastercard", "mastercard", CardPath + "key_card.b3d", INVPath + "INV_master_card.png", "", 0.0004, 1, CardPath + "master_card.png")
	
	CreateItemTemplate("Playing Card", "playcard", CardPath + "key_card.b3d", INVPath + "INV_playing_card.png", "", 0.0004, 1, CardPath + "playing_card.png")
	
	CreateItemTemplate("Quarter", "25ct", ItemsPath + "coin.b3d", INVPath + "INV_coin.png", "", 0.0005, 3)
	CreateItemTemplate("Coin", "coin", ItemsPath + "coin.b3d", INVPath + "INV_coin_rusty.png", "", 0.0005, 3, ItemsPath + "coin_rusty.png")
	CreateItemTemplate("SCP-588", "scp588", ItemsPath + "coin.b3d", INVPath + "INV_coin.png", "", 0.0005, 3)
	
	For it.ItemTemplates = Each ItemTemplates
		If it\Tex <> 0 Then
			If it\TexPath <> "" Then
				For it2.ItemTemplates = Each ItemTemplates
					If it2 <> it And it2\Tex = it\Tex Then it2\Tex = 0
				Next
			EndIf
			DeleteSingleTextureEntryFromCache(it\Tex) : it\Tex = 0
		EndIf
	Next
End Function 

Function LoadEvents%()
	If opt\IntroEnabled Then CreateEvent("cont1_173_intro", "cont1_173_intro", 0)
	CreateEvent("cont1_173", "cont1_173", 0)
	
	CreateEvent("dimension_106", "dimension_106", 0)	
	
	; ~ There's a 7% chance that SCP-106 appears in the rooms named "room2_5_hcz"
	CreateEvent("room2_5_hcz_106", "room2_5_hcz", 0, 0.07 + (0.05 * SelectedDifficulty\AggressiveNPCs))
	
	; ~ The chance for SCP-173 appearing in the first room2c_gw_lcz is about 66%
	; ~ There's a 30% chance that it appears in the later room2c_gw_lcz
	If Rand(3) < 3 Then CreateEvent("room2c_gw_lcz_173", "room2c_gw_lcz", 0)
	CreateEvent("room2c_gw_lcz_173", "room2c_gw_lcz", 0, 0.3 + (0.25 * SelectedDifficulty\AggressiveNPCs))
	
	CreateEvent("trick", "room2_lcz", 0, 0.15)	
	
	CreateEvent("1048_a", "room2_lcz", 0, 1.0)	
	
	CreateEvent("room2_storage", "room2_storage", 0)	
	
	; ~ SCP-096 spawns in the first (and last)
	CreateEvent("room2c_gw_ez_096", "room2c_gw_ez", 0)
	
	CreateEvent("room1_dead_end_106", "room1_dead_end_lcz", Rand(0, 1))
	CreateEvent("room1_dead_end_106", "room1_dead_end_ez", Rand(0, 1))
	
	CreateEvent("room2_scientists_2", "room2_scientists_2", 0)
	
	CreateEvent("room2_2_lcz", "room2_2_lcz", 0, 1.0)
	
	CreateEvent("room2_elevator", "room2_elevator", Rand(2))
	
	CreateEvent("room3_storage", "room3_storage", 0)
	
	CreateEvent("room2_6_hcz_smoke", "room2_6_hcz", 0, 0.2)
	CreateEvent("room2_6_hcz", "room2_6_hcz", 0, (0.1 * SelectedDifficulty\AggressiveNPCs))
	
	; ~ SCP-173 appears in half of the "room2_6_lcz"-rooms
	CreateEvent("room2_6_lcz_173", "room2_6_lcz", 0, 0.5 + (0.2 * SelectedDifficulty\AggressiveNPCs))
	
	; ~ The anomalous duck in "room2_2_ez"-rooms
	CreateEvent("room2_2_ez", "room2_2_ez", 0, 0.7)
	
	CreateEvent("room2_closets", "room2_closets", 0)	
	
	CreateEvent("room2_cafeteria", "room2_cafeteria", 0)	
	
	CreateEvent("room3_hcz_duck", "room3_hcz", 0)
	CreateEvent("room3_hcz_1048", "room3_hcz", 1)
	
	CreateEvent("room2_servers_hcz", "room2_servers_hcz", 0)	
	
	CreateEvent("room3_2_ez", "room3_2_ez", 0)	
	CreateEvent("room3_2_ez", "room3_3_ez", 0)
	
	; ~ The dead guard
	CreateEvent("room3_2_hcz", "room3_2_hcz", 0, 0.08)
	
	CreateEvent("room4_lcz", "room4_lcz", 0)
	
	If Rand(5) < 5 Then 
		Select Rand(3)
			Case 1
				;[Block]
				CreateEvent("682_roar", "room2_5_hcz", Rand(0, 2))
				;[End Block]
			Case 2
				;[Block]
				CreateEvent("682_roar", "room3_hcz", Rand(0, 2))	
				;[End Block]
			Case 3
				;[Block]
				CreateEvent("682_roar", "room2_5_ez", 0)
				;[End Block]
		End Select 
	EndIf 
	
	CreateEvent("room2_nuke", "room2_nuke", 0)
	
	CreateEvent("cont1_895", "cont1_895", 0)
	
	CreateEvent("room2_checkpoint", "room2_checkpoint_lcz_hcz", 0, 1.0)
	CreateEvent("room2_checkpoint", "room2_checkpoint_hcz_ez", 0, 1.0)
	
	CreateEvent("door_closing", "room3_lcz", 0, 0.1)
	CreateEvent("door_closing", "room3_2_hcz", 0, 0.1)	
	
	If Rand(2) = 1 Then
		CreateEvent("106_victim", "room3_lcz", Rand(2))
		CreateEvent("106_sinkhole", "room3_2_lcz", Rand(2, 3))
	Else
		CreateEvent("106_victim", "room3_2_lcz", Rand(2))
		CreateEvent("106_sinkhole", "room3_lcz", Rand(2, 3))
	EndIf
	CreateEvent("106_sinkhole", "room4_lcz", Rand(2))
	
	CreateEvent("cont1_079", "cont1_079", 0)	
	
	CreateEvent("cont2_049", "cont2_049", 0)
	
	CreateEvent("cont2_012", "cont2_012", 0)
	
	CreateEvent("cont1_035", "cont1_035", 0)
	
	CreateEvent("cont2_008", "cont2_008", 0)
	
	CreateEvent("cont1_106", "cont1_106", 0)	
	
	CreateEvent("cont1_372", "cont1_372", 0)
	
	CreateEvent("cont1_914", "cont1_914", 0)
	
	CreateEvent("butt_ghost", "room2_6_ez", 0)
	CreateEvent("toilet_guard", "room2_6_ez", 1)
	
	CreateEvent("room2_2_hcz_106", "room2_2_hcz", Rand(0, 3)) 
	
	CreateEvent("room2_4_hcz", "room2_4_hcz", 0, 0.4 + (0.2 * SelectedDifficulty\AggressiveNPCs))
	
	CreateEvent("room2_test_hcz", "room2_test_hcz", 0)
	CreateEvent("room2_test_lcz_173", "room2_test_lcz", 0, 1.0)	
	
	CreateEvent("room2_mt", "room2_mt", 0)
	
	CreateEvent("room2c_ec", "room2c_ec", 0)
	
	CreateEvent("gate_a_entrance", "gate_a_entrance", 0)
	CreateEvent("gate_a", "gate_a", 0)
	CreateEvent("gate_b_entrance", "gate_b_entrance", 0)
	CreateEvent("gate_b", "gate_b", 0)
	
	CreateEvent("cont1_205", "cont1_205", 0)
	
	CreateEvent("cont2_860_1", "cont2_860_1", 0)
	
	CreateEvent("cont3_966", "cont3_966", 0)
	
	CreateEvent("cont2_1123", "cont2_1123", 0)
	
	CreateEvent("room2_tesla", "room2_tesla_lcz", 0, 0.9)
	CreateEvent("room2_tesla", "room2_tesla_hcz", 0, 0.9)
	CreateEvent("room2_tesla", "room2_tesla_ez", 0, 0.9)
	
	CreateEvent("room4_2_hcz", "room4_2_hcz", 0)
	
	CreateEvent("room2_gw_2", "room2_gw_2", Rand(0, 1))
	CreateEvent("gateway", "room2_gw", 0, 1.0)
	CreateEvent("gateway", "room3_gw", 0, 1.0)
	
	CreateEvent("dimension_1499", "dimension_1499", 0)
	
	CreateEvent("cont2c_1162_arc", "cont2c_1162_arc", 0)
	
	CreateEvent("cont2_500_1499", "cont2_500_1499", 0)
	
	CreateEvent("room2_sl", "room2_sl", 0)
	
	CreateEvent("room2_medibay", "room2_medibay", 0)
	
	CreateEvent("room2_shaft", "room2_shaft", 0)
	
	CreateEvent("096_spawn", "room2_3_hcz", 0, 0.4 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	CreateEvent("096_spawn", "room2_4_hcz", 0, 0.5 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	CreateEvent("096_spawn", "room2_5_hcz", 0, 0.6 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	CreateEvent("096_spawn", "room2_6_hcz", 0, 0.4 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	CreateEvent("096_spawn", "room3_hcz", 0, 0.6 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	CreateEvent("096_spawn", "room3_2_hcz", 0, 0.6 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	CreateEvent("096_spawn", "room3_3_hcz", 0, 0.7 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	CreateEvent("096_spawn", "room4_hcz", 0, 0.6 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	CreateEvent("096_spawn", "room4_2_hcz", 0, 0.7 + (0.1 * SelectedDifficulty\AggressiveNPCs))
	
	CreateEvent("room2_4_hcz", "room2_4_lcz", 0, 0.4 + (0.2 * SelectedDifficulty\AggressiveNPCs))
	
	CreateEvent("room2_ez_035", "room2_ez", 0)
	
	CreateEvent("room2_4_hcz_106", "room2_4_hcz", 0, 0.07 + (0.05 * SelectedDifficulty\AggressiveNPCs))
	
	CreateEvent("room4_ic", "room4_ic", 0)
	
	CreateEvent("cont2_409", "cont2_409", 0)
	
	CreateEvent("cont1_005", "cont1_005", 0)
	
	CreateEvent("room2_ic", "room2_ic", 0)
End Function

Function LoadWayPoints%(LoadingStart% = 55)
	Local d.Doors, w.WayPoints, w2.WayPoints, r.Rooms, ClosestRoom.Rooms
	Local x#, y#, z#
	Local Temper% = MilliSecs2()
	Local Dist#, Dist2#
	
	For d.Doors = Each Doors
		HideEntity(d\OBJ)
		If d\OBJ2 <> 0 Then HideEntity(d\OBJ2)
		HideEntity(d\FrameOBJ)
		
		If d\room = Null Then
			ClosestRoom.Rooms = Null
			Dist = 30.0
			For r.Rooms = Each Rooms
				x = Abs(EntityX(r\OBJ, True) - EntityX(d\FrameOBJ, True))
				If x < 20.0 Then
					z = Abs(EntityZ(r\OBJ, True) - EntityZ(d\FrameOBJ, True))
					If z < 20.0 Then
						Dist2 = (x * x) + (z * z)
						If Dist2 < Dist Then
							ClosestRoom = r
							Dist = Dist2
						EndIf
					EndIf
				EndIf
			Next
		Else
			ClosestRoom = d\room
		EndIf
		If (Not d\DisableWaypoint) And d\DoorType <> WOODEN_DOOR And d\DoorType <> OFFICE_DOOR Then CreateWaypoint(EntityX(d\FrameOBJ, True), EntityY(d\FrameOBJ, True) + 0.18, EntityZ(d\FrameOBJ, True), d, ClosestRoom)
	Next
	
	Local Amount% = 0
	
	For w.WayPoints = Each WayPoints
		EntityPickMode(w\OBJ, 1, True)
		EntityRadius(w\OBJ, 0.2)
		Amount = Amount + 1
	Next
	
	Local Number% = 0
	Local Iter% = 0
	Local i%, n%
	
	For w.WayPoints = Each WayPoints
		Number = Number + 1
		Iter = Iter + 1
		If Iter = 20 Then 
			RenderLoading(LoadingStart + Floor((30.0 / Amount) * Number), "WAYPOINTS") 
			Iter = 0
		EndIf
		
		w2.WayPoints = After(w)
		
		Local CanCreateWayPoint% = False
		
		While w2 <> Null
			If w\room = w2\room Lor w\door <> Null Lor w2\door <> Null Then
				Dist = EntityDistance(w\OBJ, w2\OBJ)
				
				If w\room\MaxWayPointY = 0.0 Lor w2\room\MaxWayPointY = 0.0
					CanCreateWayPoint = True
				Else
					If Abs(EntityY(w\OBJ) - EntityY(w2\OBJ)) <= w\room\MaxWayPointY Then CanCreateWayPoint = True
				EndIf
				
				If Dist < 7.0 Then
					If CanCreateWayPoint
						If EntityVisible(w\OBJ, w2\OBJ) Then
							For i = 0 To 4
								If w\connected[i] = Null Then
									w\connected[i] = w2.WayPoints 
									w\Dist[i] = Dist
									Exit
								EndIf
							Next
							
							For n = 0 To 4
								If w2\connected[n] = Null Then 
									w2\connected[n] = w.WayPoints 
									w2\Dist[n] = Dist
									Exit
								EndIf					
							Next
						EndIf
					EndIf	
				EndIf
			EndIf
			w2 = After(w2)
		Wend
	Next
	
	For d.Doors = Each Doors
		ShowEntity(d\OBJ)
		If d\OBJ2 <> 0 Then ShowEntity(d\OBJ2)
		ShowEntity(d\FrameOBJ)		
	Next
	
	For w.WayPoints = Each WayPoints
		EntityPickMode(w\OBJ, 0, 0)
		EntityRadius(w\OBJ, 0)
		
		For i = 0 To 4
			If w\connected[i] <> Null Then 
				Local tLine% = CreateLine(EntityX(w\OBJ, True), EntityY(w\OBJ, True), EntityZ(w\OBJ, True), EntityX(w\connected[i]\OBJ, True), EntityY(w\connected[i]\OBJ, True), EntityZ(w\connected[i]\OBJ, True))
				
				EntityColor(tLine, 255.0, 0.0, 0.0)
				EntityParent(tLine, w\OBJ)
			EndIf
		Next
	Next
End Function

Global SoundEmitter%
Global TempSounds%[10]
Global TempSoundCHN%
Global TempSoundIndex% = 0

; ~ The Music now has to be pre-defined, as the new system uses streaming instead of the usual sound loading system Blitz3D has
Global Music$[30]

Music[0] = "LightContainmentZone"
Music[1] = "HeavyContainmentZone"
Music[2] = "EntranceZone"
Music[3] = "PD"
Music[4] = "Cont_079"
Music[5] = "Gate_B1"
Music[6] = "Gate_B2"
Music[7] = "Room3_storage"
Music[8] = "Cont_049"
Music[9] = "Cont_860_1"
Music[10] = "106Chase"
Music[11] = "Menu"
Music[12] = "860_2Chase"
Music[13] = "Cont_173_Intro"
Music[14] = "Using178"
Music[15] = "PDTrench"
Music[16] = "Cont_205"
Music[17] = "Gate_A"
Music[18] = "1499"
Music[19] = "1499_1Chase"
Music[20] = "049Chase"
Music[21] = "..\Ending\MenuBreath"
Music[22] = "Cont_914"
Music[23] = "Ending"
Music[24] = "Credits"
Music[25] = "SaveMeFrom"
Music[26] = "Cont_106"
Music[27] = "Cont_035"
Music[28] = "Cont_409"
Music[29] = "MaintenanceTunnels"

Global MusicCHN%
MusicCHN = StreamSound_Strict("SFX\Music\" + Music[2] + ".ogg", opt\MusicVolume, Mode)

Global NowPlaying% = 2, ShouldPlay% = 11
Global CurrMusic% = True

Dim OpenDoorSFX%(5, 2), CloseDoorSFX%(3, 2)
Global BigDoorErrorSFX%[3]

Global KeyCardSFX1% 
Global KeyCardSFX2% 
Global ScannerSFX1%
Global ScannerSFX2%

Global DoorBudgeSFX1%
Global DoorBudgeSFX2%
Global DoorLockSFX%

Global OpenDoorFastSFX%
Global CautionSFX% 

Global NuclearSirenSFX%

Global CameraSFX% 

Global StoneDragSFX% 

Global GunshotSFX% 
Global Gunshot2SFX% 
Global Gunshot3SFX% 
Global BulletHitSFX% 

Global TeslaIdleSFX% 
Global TeslaActivateSFX% 
Global TeslaPowerUpSFX% 
Global TeslaShockSFX%

Global MagnetUpSFX%, MagnetDownSFX%
Global FemurBreakerSFX%
Global EndBreathCHN%
Global EndBreathSFX%

Global CrouchSFX%

Global DecaySFX%[5]

Global BurstSFX% 

Global HissSFX%

Global RustleSFX%[6]

Global Use914SFX%
Global Death914SFX% 

Global DripSFX%[4]

Global KnobSFX%[2]

Global LeverSFX%, LightSFX% 
Global ButtGhostSFX% 

Dim RadioSFX%(2, 9) 

Global RadioSquelch% 
Global RadioStatic% 
Global RadioStatic895%
Global RadioBuzz% 

Global SCRAMBLESFX%
Global SCRAMBLECHN%

Global NVGSFX%[2]

Global LowBatterySFX%[2]
Global LowBatteryCHN%[2]

Global ElevatorBeepSFX%, ElevatorMoveSFX% 

Global PickSFX%[4]

Global AmbientSFXCHN%, CurrAmbientSFX%
Global AmbientSFXAmount%[6]

Dim AmbientSFX%(5, 15)

Global OldManSFX%[9]

Global Scp173SFX%[3]

Global HorrorSFX%[20]

Global MissSFX%

Global IntroSFX%[12]

Global AlarmSFX%[4]

Global CommotionState%[25]

Global HeartBeatSFX% 

Global VomitSFX%

Dim BreathSFX%(1, 4)
Global BreathCHN%

Global BreathGasRelaxedSFX%
Global BreathGasRelaxedCHN%

Global NeckSnapSFX%[3]

Global DamageSFX%[14]

Global MTFSFX%[2]

Global CoughSFX%[3]
Global CoughCHN%, VomitCHN%

Global MachineSFX% 
Global ApacheSFX%

Global CurrStepSFX%
Dim StepSFX%(2, 1, 7) ; ~ (Normal / Metal, Walk / Run, ID)

Global Step2SFX%[15]

Global VehicleSFX%[2]

Global ExplosionSFX%

Global RadioCHN%[7]

Global IntercomStreamCHN%

Global PlayCustomMusic% = False, CustomMusic% = 0

Global UserTrackCheck% = 0, UserTrackCheck2% = 0
Global UserTrackMusicAmount% = 0, CurrUserTrack%, UserTrackFlag% = False
Global UserTrackName$[256]

Function LoadSounds%()
	Local i%
	
	RenderLoading(45, "SOUNDS")
	
	For i = 0 To 2
		OpenDoorSFX(DEFAULT_DOOR, i) = LoadSound_Strict("SFX\Door\DoorOpen" + (i + 1) + ".ogg") ; ~ Also one-sided door
		CloseDoorSFX(DEFAULT_DOOR, i) = LoadSound_Strict("SFX\Door\DoorClose" + (i + 1) + ".ogg") ; ~ Also one-sided door
		OpenDoorSFX(ELEVATOR_DOOR, i) = LoadSound_Strict("SFX\Door\ElevatorOpen" + (i + 1) + ".ogg")
		CloseDoorSFX(ELEVATOR_DOOR, i) = LoadSound_Strict("SFX\Door\ElevatorClose" + (i + 1) + ".ogg")
		OpenDoorSFX(HEAVY_DOOR, i) = LoadSound_Strict("SFX\Door\Door2Open" + (i + 1) + ".ogg")
		CloseDoorSFX(HEAVY_DOOR, i) = LoadSound_Strict("SFX\Door\Door2Close" + (i + 1) + ".ogg")
		OpenDoorSFX(BIG_DOOR, i) = LoadSound_Strict("SFX\Door\BigDoorOpen" + (i + 1) + ".ogg")
		CloseDoorSFX(BIG_DOOR, i) = LoadSound_Strict("SFX\Door\BigDoorClose" + (i + 1) + ".ogg")
		OpenDoorSFX(OFFICE_DOOR, i) = LoadSound_Strict("SFX\Door\OfficeDoorOpen" + (i + 1) + ".ogg")
		OpenDoorSFX(WOODEN_DOOR, i) = LoadSound_Strict("SFX\Door\WoodenDoorOpen" + (i + 1) + ".ogg")
		BigDoorErrorSFX[i] = LoadSound_Strict("SFX\Door\BigDoorError" + (i + 1) + ".ogg")
	Next
	
	KeyCardSFX1 = LoadSound_Strict("SFX\Interact\KeyCardUse1.ogg")
	KeyCardSFX2 = LoadSound_Strict("SFX\Interact\KeyCardUse2.ogg")
	ScannerSFX1 = LoadSound_Strict("SFX\Interact\ScannerUse1.ogg")
	ScannerSFX2 = LoadSound_Strict("SFX\Interact\ScannerUse2.ogg")
	
	DoorBudgeSFX1 = LoadSound_Strict("SFX\Interact\DoorBudge1.ogg")
	DoorBudgeSFX2 = LoadSound_Strict("SFX\Interact\DoorBudge2.ogg")
	
	DoorLockSFX = LoadSound_Strict("SFX\Interact\DoorLock.ogg")
	
	OpenDoorFastSFX = LoadSound_Strict("SFX\Door\DoorOpenFast.ogg")
	CautionSFX = LoadSound_Strict("SFX\Room\LockroomSiren.ogg")
	
	CameraSFX = LoadSound_Strict("SFX\General\Camera.ogg") 
	
	StoneDragSFX = LoadSound_Strict("SFX\SCP\173\StoneDrag.ogg")
	
	GunshotSFX = LoadSound_Strict("SFX\General\Gunshot.ogg")
	Gunshot2SFX = LoadSound_Strict("SFX\General\Gunshot2.ogg")
	Gunshot3SFX = LoadSound_Strict("SFX\General\BulletMiss.ogg")
	BulletHitSFX = LoadSound_Strict("SFX\General\BulletHit.ogg")
	
	TeslaIdleSFX = LoadSound_Strict("SFX\Room\Tesla\Idle.ogg")
	TeslaActivateSFX = LoadSound_Strict("SFX\Room\Tesla\WindUp.ogg")
	TeslaPowerUpSFX = LoadSound_Strict("SFX\Room\Tesla\PowerUp.ogg")
	TeslaShockSFX = LoadSound_Strict("SFX\Room\Tesla\Shock.ogg")
	
	MagnetUpSFX = LoadSound_Strict("SFX\Room\106Chamber\MagnetUp.ogg") 
	MagnetDownSFX = LoadSound_Strict("SFX\Room\106Chamber\MagnetDown.ogg")
	
	For i = 0 To 3
		DecaySFX[i] = LoadSound_Strict("SFX\SCP\106\Decay" + i + ".ogg")
	Next
	
	BurstSFX = LoadSound_Strict("SFX\Room\TunnelBurst.ogg")
	
	HissSFX = LoadSound_Strict("SFX\General\Hiss.ogg")
	
	For i = 0 To 5
		RustleSFX[i] = LoadSound_Strict("SFX\SCP\372\Rustle" + i + ".ogg")
	Next
	
	Death914SFX = LoadSound_Strict("SFX\SCP\914\PlayerDeath.ogg") 
	Use914SFX = LoadSound_Strict("SFX\SCP\914\PlayerUse.ogg")
	MachineSFX = LoadSound_Strict("SFX\SCP\914\Refining.ogg")
	
	For i = 0 To 3
		DripSFX[i] = LoadSound_Strict("SFX\Character\D9341\BloodDrip" + i + ".ogg")
	Next
	
	LeverSFX = LoadSound_Strict("SFX\Interact\LeverFlip.ogg") 
	
	LightSFX = LoadSound_Strict("SFX\General\LightSwitch.ogg")
	
	ButtGhostSFX = LoadSound_Strict("SFX\SCP\Joke\789J.ogg")
	
	RadioSFX(0, 0) = LoadSound_Strict("SFX\Radio\RadioAlarm.ogg")
	RadioSFX(0, 1) = LoadSound_Strict("SFX\Radio\RadioAlarm2.ogg")
	For i = 0 To 8
		RadioSFX(1, i) = LoadSound_Strict("SFX\Radio\SCPRadio" + i + ".ogg")
	Next
	RadioSquelch = LoadSound_Strict("SFX\Radio\Squelch.ogg")
	RadioStatic = LoadSound_Strict("SFX\Radio\Static.ogg")
	RadioStatic895 = LoadSound_Strict("SFX\Radio\Static895.ogg")
	RadioBuzz = LoadSound_Strict("SFX\Radio\Buzz.ogg")
	
	ElevatorBeepSFX = LoadSound_Strict("SFX\General\Elevator\Beep.ogg") 
	ElevatorMoveSFX = LoadSound_Strict("SFX\General\Elevator\Moving.ogg") 
	
	For i = 0 To 3
		PickSFX[i] = LoadSound_Strict("SFX\Interact\PickItem" + i + ".ogg")
	Next
	
	; ~ 0 = Light Containment Zone
	; ~ 1 = Heavy Containment Zone
	; ~ 2 = Entrance Zone
	; ~ 3 = General
	; ~ 4 = Pre-Breach
	; ~ 5 = SCP-860-1
	AmbientSFXAmount[0] = 8 
	AmbientSFXAmount[1] = 11
	AmbientSFXAmount[2] = 12
	AmbientSFXAmount[3] = 15 
	AmbientSFXAmount[4] = 5
	AmbientSFXAmount[5] = 10
	
	For i = 0 To 2
		OldManSFX[i] = LoadSound_Strict("SFX\SCP\106\Corrosion" + (i + 1) + ".ogg")
	Next
	OldManSFX[3] = LoadSound_Strict("SFX\SCP\106\Laugh.ogg")
	OldManSFX[4] = LoadSound_Strict("SFX\SCP\106\Breathing.ogg")
	OldManSFX[5] = LoadSound_Strict("SFX\Room\PocketDimension\Enter.ogg")
	For i = 0 To 2
		OldManSFX[i + 6] = LoadSound_Strict("SFX\SCP\106\WallDecay" + (i + 1) + ".ogg")
	Next
	
	For i = 0 To 2
		Scp173SFX[i] = LoadSound_Strict("SFX\SCP\173\Rattle" + (i + 1) + ".ogg")
	Next
	
	For i = 0 To 11
		HorrorSFX[i] = LoadSound_Strict("SFX\Horror\Horror" + i + ".ogg")
	Next
	For i = 14 To 15
		HorrorSFX[i] = LoadSound_Strict("SFX\Horror\Horror" + i + ".ogg")
	Next
	
	For i = 5 To 7
		IntroSFX[i] = LoadSound_Strict("SFX\Room\Intro\Bang" + (i - 4) + ".ogg")
	Next
	For i = 8 To 10
		IntroSFX[i] = LoadSound_Strict("SFX\Room\Intro\Light" + (i - 7) + ".ogg")
	Next
	IntroSFX[11] = LoadSound_Strict("SFX\Room\Intro\173Vent.ogg")
	
	For i = 0 To 3
		AlarmSFX[i] = LoadSound_Strict("SFX\Alarm\Alarm" + (i + 1) + ".ogg")
	Next
	
	HeartBeatSFX = LoadSound_Strict("SFX\Character\D9341\HeartBeat.ogg")
	
	For i = 0 To 4
		BreathSFX(0, i) = LoadSound_Strict("SFX\Character\D9341\Breath" + i + ".ogg")
		BreathSFX(1, i) = LoadSound_Strict("SFX\Character\D9341\Breath" + i + "Gas.ogg")
	Next
	
	For i = 0 To 2
		NeckSnapSFX[i] = LoadSound_Strict("SFX\SCP\173\NeckSnap" + (i + 1) + ".ogg")
	Next
	
	For i = 0 To 13
		DamageSFX[i] = LoadSound_Strict("SFX\Character\D9341\Damage" + (i + 1) + ".ogg")
	Next
	
	For i = 0 To 2
		CoughSFX[i] = LoadSound_Strict("SFX\Character\D9341\Cough" + (i + 1) + ".ogg")
	Next
	
	ApacheSFX = LoadSound_Strict("SFX\Character\Apache\Propeller.ogg")
	
	For i = 0 To 7
		StepSFX(0, 0, i) = LoadSound_Strict("SFX\Step\Step" + (i + 1) + ".ogg")
		StepSFX(1, 0, i) = LoadSound_Strict("SFX\Step\StepMetal" + (i + 1) + ".ogg")
		StepSFX(0, 1, i) = LoadSound_Strict("SFX\Step\Run" + (i + 1) + ".ogg")
		StepSFX(1, 1, i) = LoadSound_Strict("SFX\Step\RunMetal" + (i + 1) + ".ogg")
		If i < 3 Then StepSFX(2, 0, i) = LoadSound_Strict("SFX\Step\StepPD" + (i + 1) + ".ogg")
	Next
	For i = 0 To 2
		Step2SFX[i] = LoadSound_Strict("SFX\Step\StepForest" + (i + 1) + ".ogg")
	Next
	For i = 3 To 5
		Step2SFX[i] = LoadSound_Strict("SFX\Character\MTF\Step" + (i - 2) + ".ogg")
	Next
	For i = 6 To 12
		Step2SFX[i] = LoadSound_Strict("SFX\Step\SCP\StepMetal" + (i - 5) + ".ogg")
	Next
	For i = 13 To 14
		Step2SFX[i] = LoadSound_Strict("SFX\Step\StepFluid" + (i - 12) + ".ogg")
	Next
	
	VehicleSFX[0] = LoadSound_Strict("SFX\Character\Vehicle\Idle.ogg")
	VehicleSFX[1] = LoadSound_Strict("SFX\Character\Vehicle\Move.ogg")
	
	MissSFX = LoadSound_Strict("SFX\General\Miss.ogg")
	
	BreathGasRelaxedSFX = LoadSound_Strict("SFX\Character\D9341\BreathGasRelaxed.ogg")
	
	CrouchSFX = LoadSound_Strict("SFX\Character\D9341\Crouch.ogg")
	
	SCRAMBLESFX = LoadSound_Strict("SFX\General\SCRAMBLE.ogg")
	
	NVGSFX[0] = LoadSound_Strict("SFX\General\NVGOn.ogg")
	NVGSFX[1] = LoadSound_Strict("SFX\General\NVGOff.ogg")
	
	For i = 0 To 1
		LowBatterySFX[i] = LoadSound_Strict("SFX\General\LowBattery" + (i + 1) + ".ogg")
	Next
	
	For i = 0 To 1
		KnobSFX[i] = LoadSound_Strict("SFX\Room\914Chamber\Knob" + (i + 1) + ".ogg")
	Next
End Function

Function LoadEntities%()
	CatchErrors("Uncaught (LoadEntities)")
	
	Local i%, Tex%
	Local b%, t1%, SF%
	Local Name$, Test%, File$
	
	DeInitMainMenuAssets()
	
	RenderLoading(0, "PLAYER")
	
	SoundEmitter = CreatePivot()
	
	me\Collider = CreatePivot()
	EntityRadius(me\Collider, 0.15, 0.30)
	EntityPickMode(me\Collider, 1)
	EntityType(me\Collider, HIT_PLAYER)
	
	me\Head = CreatePivot()
	EntityRadius(me\Head, 0.15)
	EntityType(me\Head, HIT_PLAYER)
	
	Camera = CreateCamera()
	CameraViewport(Camera, 0, 0, opt\GraphicWidth, opt\GraphicHeight)
	CameraRange(Camera, 0.05, opt\CameraFogFar)
	CameraFogMode(Camera, 1)
	CameraFogRange(Camera, opt\CameraFogNear, opt\CameraFogFar)
	
	RenderLoading(5, "ICONS")
	
	t\IconID[0] = LoadImage_Strict("GFX\gui\walk_icon.png")
	t\IconID[0] = ScaleImage2(t\IconID[0], MenuScale, MenuScale)
	t\IconID[1] = LoadImage_Strict("GFX\gui\sprint_icon.png")
	t\IconID[1] = ScaleImage2(t\IconID[1], MenuScale, MenuScale)
	t\IconID[2] = LoadImage_Strict("GFX\gui\crouch_icon.png")
	t\IconID[2] = ScaleImage2(t\IconID[2], MenuScale, MenuScale)
	For i = 3 To 4
		t\IconID[i] = LoadImage_Strict("GFX\gui\blink_icon(" + (i - 2) + ").png")
		t\IconID[i] = ScaleImage2(t\IconID[i], MenuScale, MenuScale)
	Next
	For i = 5 To 6
		t\IconID[i] = LoadImage_Strict("GFX\gui\hand_symbol(" + (i - 4) + ").png")
		t\IconID[i] = ScaleImage2(t\IconID[i], MenuScale, MenuScale)
	Next
	t\IconID[7] = LoadImage_Strict("GFX\gui\scp_268_icon.png")
	t\IconID[7] = ScaleImage2(t\IconID[7], MenuScale, MenuScale)
	t\IconID[8] = LoadImage_Strict("GFX\gui\shield_icon.png")
	t\IconID[8] = ScaleImage2(t\IconID[8], MenuScale, MenuScale)
	
	If (Left(CurrentDate(), 7) = "28 Jun ") Then
		QuickLoadIcon = LoadImage_Strict("GFX\menu\QuickLoadingPride.png")
	Else
		QuickLoadIcon = LoadImage_Strict("GFX\menu\QuickLoading.png")
	EndIf
		QuickLoadIcon = ScaleImage2(QuickLoadIcon, MenuScale, MenuScale)
	
	For i = 0 To MAXACHIEVEMENTS - 1
		Local Loc2% = GetINISectionLocation(AchievementsFile, "a" + Str(i))
		
		achv\AchievementStrings[i] = GetINIString2(AchievementsFile, Loc2, "AchvName")
		achv\AchievementDescs[i] = GetINIString2(AchievementsFile, Loc2, "AchvDesc")
		
		Local Image$ = GetINIString2(AchievementsFile, Loc2, "AchvImage") 
		
		achv\AchvIMG[i] = LoadImage_Strict("GFX\menu\achievements\" + Image + ".png")
		achv\AchvIMG[i] = ScaleImage2(achv\AchvIMG[i], opt\GraphicHeight / 768.0, opt\GraphicHeight / 768.0)
	Next
	
	achv\AchvLocked = LoadImage_Strict("GFX\menu\achievements\AchvLocked.png")
	achv\AchvLocked = ScaleImage2(achv\AchvLocked, opt\GraphicHeight / 768.0, opt\GraphicHeight / 768.0)
	
	t\ImageID[0] = LoadImage_Strict("GFX\menu\pause_menu.png")
	t\ImageID[0] = ScaleImage2(t\ImageID[0], MenuScale, MenuScale)
	MaskImage(t\ImageID[0], 255, 255, 0)
	
	If (Not opt\SmoothBars) Then
		t\ImageID[1] = LoadImage_Strict("GFX\gui\blink_meter(2).png")
		t\ImageID[1] = ScaleImage2(t\ImageID[1], MenuScale, MenuScale)
		
		For i = 2 To 3
			t\ImageID[i] = LoadImage_Strict("GFX\gui\stamina_meter(" + (i - 1) + ").png")
			t\ImageID[i] = ScaleImage2(t\ImageID[i], MenuScale, MenuScale)
		Next
	EndIf
	
	t\ImageID[4] = LoadImage_Strict("GFX\gui\keypad_HUD.png")
	t\ImageID[4] = ScaleImage2(t\ImageID[4], MenuScale, MenuScale)
	MaskImage(t\ImageID[4], 255, 0, 255)
	
	t\ImageID[5] = LoadImage_Strict("GFX\gui\scp_294_panel.png")
	t\ImageID[5] = ScaleImage2(t\ImageID[5], MenuScale, MenuScale)
	MaskImage(t\ImageID[5], 255, 0, 255)
	
	t\ImageID[6] = LoadImage_Strict("GFX\gui\night_vision_goggles_battery.png")
	t\ImageID[6] = ScaleImage2(t\ImageID[6], MenuScale, MenuScale)
	MaskImage(t\ImageID[6], 255, 0, 255)
	
	t\ImageID[7] = CreateImage(opt\GraphicWidth, opt\GraphicHeight)
	
	RenderLoading(10, "MODELS & TEXTURES")
	
	LoadMissingTexture()
	
	AmbientLightRoomTex = CreateTextureUsingCacheSystem(1, 1)
	TextureBlend(AmbientLightRoomTex, 3)
	SetBuffer(TextureBuffer(AmbientLightRoomTex))
	ClsColor(0, 0, 0)
	Cls()
	SetBuffer(BackBuffer())
	
	CreateBlurImage()
	CameraProjMode(ArkBlurCam, 0)
	
	t\OverlayTextureID[0] = LoadTexture_Strict("GFX\gui\fog.png", 1, DeleteAllTextures) ; ~ FOG
	t\OverlayID[0] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[0], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[0], t\OverlayTextureID[0])
	EntityBlend(t\OverlayID[0], 2)
	EntityOrder(t\OverlayID[0], -1000)
	MoveEntity(t\OverlayID[0], 0.0, 0.0, 1.0)
	
	t\OverlayTextureID[1] = LoadTexture_Strict("GFX\gui\gas_mask_overlay.png", 1, DeleteAllTextures) ; ~ GAS MASK
	t\OverlayID[1] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[1], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[1], t\OverlayTextureID[1])
	EntityBlend(t\OverlayID[1], 2)
	EntityFX(t\OverlayID[1], 1)
	EntityOrder(t\OverlayID[1], -1003)
	MoveEntity(t\OverlayID[1], 0.0, 0.0, 1.0)
	
	t\OverlayTextureID[2] = LoadTexture_Strict("GFX\gui\hazmat_suit_overlay.png", 1, DeleteAllTextures) ; ~ HAZMAT SUIT
	t\OverlayID[2] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[2], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[2], t\OverlayTextureID[2])
	EntityBlend(t\OverlayID[2], 2)
	EntityFX(t\OverlayID[2], 1)
	EntityOrder(t\OverlayID[2], -1003)
	MoveEntity(t\OverlayID[2], 0, 0, 1.0)
	
	t\OverlayTextureID[3] = LoadTexture_Strict("GFX\gui\scp_008_overlay.png", 1, DeleteAllTextures) ; ~ SCP-008
	t\OverlayID[3] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[3], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[3], t\OverlayTextureID[3])
	EntityBlend(t\OverlayID[3], 3)
	EntityFX(t\OverlayID[3], 1)
	EntityOrder(t\OverlayID[3], -1003)
	MoveEntity(t\OverlayID[3], 0.0, 0.0, 1.0)
	
	t\OverlayTextureID[4] = LoadTexture_Strict("GFX\gui\goggles_overlay.png", 1, DeleteAllTextures) ; ~ NIGHT VISION GOGGLES ~ SCRAMBLE Gear
	t\OverlayID[4] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[4], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[4], t\OverlayTextureID[4])
	EntityBlend(t\OverlayID[4], 2)
	EntityFX(t\OverlayID[4], 1)
	EntityOrder(t\OverlayID[4], -1003)
	MoveEntity(t\OverlayID[4], 0.0, 0.0, 1.0)
	
	t\OverlayTextureID[5] = CreateTextureUsingCacheSystem(SMALLEST_POWER_TWO_HALF, SMALLEST_POWER_TWO_HALF, 1 + 2) ; ~ DARK
	SetBuffer(TextureBuffer(t\OverlayTextureID[5]))
	Cls()
	SetBuffer(BackBuffer())
	t\OverlayID[5] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[5], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[5], t\OverlayTextureID[5])
	EntityBlend(t\OverlayID[5], 1)
	EntityOrder(t\OverlayID[5], -1002)
	MoveEntity(t\OverlayID[5], 0.0, 0.0, 1.0)
	EntityAlpha(t\OverlayID[5], 0.0)
	
	t\OverlayTextureID[6] = CreateTextureUsingCacheSystem(SMALLEST_POWER_TWO_HALF, SMALLEST_POWER_TWO_HALF, 1 + 2) ; ~ LIGHT
	SetBuffer(TextureBuffer(t\OverlayTextureID[6]))
	ClsColor(255, 255, 255)
	Cls()
	ClsColor(0, 0, 0)
	SetBuffer(BackBuffer())
	t\OverlayID[6] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[6], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[6], t\OverlayTextureID[6])
	EntityBlend(t\OverlayID[6], 1)
	EntityOrder(t\OverlayID[6], -1002)
	MoveEntity(t\OverlayID[6], 0.0, 0.0, 1.0)
	
	t\OverlayTextureID[7] = LoadTexture_Strict("GFX\gui\scp_409_overlay.png", 1, DeleteAllTextures) ; ~ SCP-409
	t\OverlayID[7] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[7], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[7], t\OverlayTextureID[7])
	EntityBlend(t\OverlayID[7], 3)
	EntityFX(t\OverlayID[7], 1)
	EntityOrder(t\OverlayID[7], -1003)
	MoveEntity(t\OverlayID[7], 0.0, 0.0, 1.0)
	
	t\OverlayTextureID[8] = LoadTexture_Strict("GFX\gui\helmet_overlay.png", 1, DeleteAllTextures) ; ~ HELMET
	t\OverlayID[8] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[8], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[8], t\OverlayTextureID[8])
	EntityBlend(t\OverlayID[8], 2)
	EntityFX(t\OverlayID[8], 1)
	EntityOrder(t\OverlayID[8], -1003)
	MoveEntity(t\OverlayID[8], 0.0, 0.0, 1.0)
	
	t\OverlayTextureID[9] = LoadTexture_Strict("GFX\gui\bloody_overlay.png", 1, DeleteAllTextures) ; ~ BLOOD
	t\OverlayID[9] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[9], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[9], t\OverlayTextureID[9])
	EntityBlend(t\OverlayID[9], 2)
	EntityFX(t\OverlayID[9], 1)
	EntityOrder(t\OverlayID[9], -1003)
	MoveEntity(t\OverlayID[9], 0.0, 0.0, 1.0)
	
	t\OverlayTextureID[10] = LoadTexture_Strict("GFX\gui\fog_gas_mask.png", 1, DeleteAllTextures) ; ~ FOG IN GAS MASK
	t\OverlayID[10] = CreateSprite(ArkBlurCam)
	ScaleSprite(t\OverlayID[10], 1.0, Float(opt\GraphicHeight) / Float(opt\GraphicWidth))
	EntityTexture(t\OverlayID[10], t\OverlayTextureID[10])
	EntityBlend(t\OverlayID[10], 3)
	EntityFX(t\OverlayID[10], 1)
	EntityOrder(t\OverlayID[10], -1002)
	MoveEntity(t\OverlayID[10], 0.0, 0.0, 1.0)
	
	For i = 0 To 10
		HideEntity(t\OverlayID[i])
	Next
	t\OverlayTextureID[11] = LoadTexture_Strict("GFX\tesla_overlay.png", 1 + 2, DeleteAllTextures)
	t\OverlayTextureID[12] = LoadTexture_Strict("GFX\gui\fog_goggles.png", 1, DeleteAllTextures)
	
	LoadDecals()
	
	LoadParticles()
	
	LoadMaterials(MaterialsFile)
	
	LoadDoors()
	
	LoadNPCs()
	
	LoadLevers()
	
	LoadMonitors()
	
	LoadSecurityCams()
	
	LoadMisc()
	
	LoadItems()
	
	RenderLoading(15, "CHUNKS")
	
	SetChunkDataValues()
	
	RenderLoading(20, "USER TRACKS")
	
	UserTrackMusicAmount = 0
	If opt\EnableUserTracks Then
		Local DirPath$ = "SFX\Radio\UserTracks\"
		
		If FileType(DirPath) <> 2 Then CreateDir(DirPath)
		
		Local Dir% = ReadDir("SFX\Radio\UserTracks\")
		
		Repeat
			File = NextFile(Dir)
			If File = "" Then Exit
			If FileType("SFX\Radio\UserTracks\" + File) = 1 Then
				Test = LoadSound("SFX\Radio\UserTracks\" + File)
				If Test <> 0 Then
					UserTrackName[UserTrackMusicAmount] = File
					UserTrackMusicAmount = UserTrackMusicAmount + 1
				EndIf
				FreeSound(Test) : Test = 0
			EndIf
		Forever
		CloseDir(Dir)
	EndIf
	
	RenderLoading(25, "GRAPHICS")
	
	TextureLodBias(opt\TextureDetailsLevel)
	TextureAnisotropic(opt\AnisotropicLevel)
	
	RenderLoading(30, "CONSOLE")
	
	ConsoleR = 0 : ConsoleG = 255 : ConsoleB = 255
	
	CreateConsoleMsg("Console commands: ")
	CreateConsoleMsg("  - help [page]")
	CreateConsoleMsg("  - teleport [room name]")
	CreateConsoleMsg("  - godmode [on / off]")
	CreateConsoleMsg("  - noclip [on / off]")
	CreateConsoleMsg("  - infinitestamina [on / off]")
	CreateConsoleMsg("  - noblink [on / off]")
	CreateConsoleMsg("  - notarget [on / off]")
	CreateConsoleMsg("  - noclipspeed [x] (default = 2.0)")
	CreateConsoleMsg("  - wireframe [on / off]")
	CreateConsoleMsg("  - debughud [category]")
	CreateConsoleMsg("  - camerafog [near] [far]")
	CreateConsoleMsg("  - heal")
	CreateConsoleMsg("  - revive")
	CreateConsoleMsg("  - asd")
	CreateConsoleMsg("  - spawnitem [item name]")
	CreateConsoleMsg("  - 106retreat")
	CreateConsoleMsg("  - disable173 / enable173")
	CreateConsoleMsg("  - disable106 / enable106")
	CreateConsoleMsg("  - spawn [NPC type]")
	
	CatchErrors("LoadEntities")
End Function

Function InitStats%()
	me\Controllable = True: me\Playable = True : me\SelectedEnding = -1
	
	opt\CameraFogFar = 6.0
	opt\CameraFogNear = 0.1
	HideDistance = 17.0
	
	If opt\DebugMode Then
		InitCheats()
	Else
		ClearCheats()
	EndIf
	
	as\Timer = 70.0 * 120.0
	If SelectedDifficulty\SaveType <> SAVE_ANYWHERE Then opt\AutoSaveEnabled = False
	If SelectedDifficulty\Name = "Apollyon" Then opt\CanOpenConsole = False
	
	LoadAchievementsFile()
End Function

Function InitNewGame%()
	CatchErrors("Uncaught (InitNewGame)")
	
	Local de.Decals, d.Doors, it.Items, r.Rooms, sc.SecurityCams, e.Events, rt.RoomTemplates
	Local twp.TempWayPoints, ts.TempScreens, tp.TempProps
	Local i%, Skip%
	
	LoadEntities()
	LoadSounds()
	
	InitStats()
	
	MaxItemAmount = SelectedDifficulty\InventorySlots
	Dim Inventory.Items(MaxItemAmount - 1)
	
	RenderLoading(50, "STATS")
	
	me\BlinkTimer = -10.0 : me\BlinkEffect = 1.0 : me\Stamina = 100.0 : me\StaminaEffect = 1.0 : me\HeartBeatRate = 70.0 : me\Funds = Rand(4)
	
	I_005\ChanceToSpawn = Rand(3) : I_714\Using = 1
	
	TakeOffTimer = 500.0
	
	AccessCode = 0
	Repeat
		For i = 0 To 3
			AccessCode = AccessCode + (Rand(9) * (10 ^ i))
		Next
		Skip = False
		If AccessCode <> 7816 And AccessCode <> 5731 And AccessCode <> 2411 Then
			Skip = True
		Else
			AccessCode = 0
		EndIf
	Until Skip
	
	AccessCode2 = 0
	Repeat
		For i = 0 To 3
			AccessCode2 = AccessCode2 + (Rand(9) * (10 ^ i))
		Next
		Skip = False
		If AccessCode2 <> 7816 And AccessCode2 <> 5731 And AccessCode <> 2411 And AccessCode2 <> AccessCode Then
			Skip = True
		Else
			AccessCode2 = 0
		EndIf
	Until Skip
	
	RenderLoading(55, "ROOMS")
	
	If SelectedMap = "" Then
		CreateMap()
	Else
		LoadMap("Map Creator\Maps\" + SelectedMap)
	EndIf
	
	LoadWayPoints()
	
	n_I\Curr173 = CreateNPC(NPCType173, 0.0, -30.0, 0.0)
	n_I\Curr106 = CreateNPC(NPCType106, 0.0, -30.0, 0.0)
	n_I\Curr106\State = 70.0 * 60.0 * Rnd(12.0, 17.0)
	
	For d.Doors = Each Doors
		EntityParent(d\OBJ, 0)
		If d\DoorType = DEFAULT_DOOR Lor d\DoorType = ONE_SIDED_DOOR Lor d\DoorType = SCP_914_DOOR Then
			MoveEntity(d\OBJ, 0.0, 0.0, 8.0 * RoomScale)
		ElseIf d\DoorType = OFFICE_DOOR Lor d\DoorType = WOODEN_DOOR
			MoveEntity(d\OBJ, (((d\DoorType = OFFICE_DOOR) * 92.0) + ((d\DoorType = WOODEN_DOOR) * 70.0)) * RoomScale, 0.0, 0.0)
		EndIf
		If d\OBJ2 <> 0 Then
			EntityParent(d\OBJ2, 0)
			If d\DoorType = DEFAULT_DOOR Lor d\DoorType = ONE_SIDED_DOOR Lor d\DoorType = SCP_914_DOOR Then MoveEntity(d\OBJ2, 0.0, 0.0, 8.0 * RoomScale)
		EndIf
		If d\FrameOBJ <> 0 Then EntityParent(d\FrameOBJ, 0)
		For i = 0 To 1
			If d\Buttons[i] <> 0 Then EntityParent(d\Buttons[i], 0)
			If d\ElevatorPanel[i] <> 0 Then EntityParent(d\ElevatorPanel[i], 0)
		Next
	Next
	
	For it.Items = Each Items
		EntityType(it\Collider, HIT_ITEM)
		EntityParent(it\Collider, 0)
	Next
	
	For sc.SecurityCams = Each SecurityCams
		sc\Angle = EntityYaw(sc\BaseOBJ) + sc\Angle
		EntityParent(sc\BaseOBJ, 0)
		If sc\MonitorOBJ <> 0 Then EntityParent(sc\MonitorOBJ, 0)
	Next	
	
	For r.Rooms = Each Rooms
		For i = 0 To MaxRoomLights - 1
			If r\Lights[i] <> 0 Then
				EntityParent(r\Lights[i], 0)
			Else
				Exit
			EndIf
		Next
		
		If (Not r\RoomTemplate\DisableDecals) Then
			If Rand(4) = 1 Then
				de.Decals = CreateDecal(Rand(DECAL_BLOOD_1, DECAL_BLOOD_2), EntityX(r\OBJ) + Rnd(-2.0, 2.0), r\y + 0.005, EntityZ(r\OBJ) + Rnd(-2.0, 2.0), 90.0, Rnd(360.0), 0.0, Rnd(0.1, 0.4), Rnd(0.85, 0.95))
				EntityParent(de\OBJ, r\OBJ)
			EndIf
			If Rand(4) = 1 Then
				de.Decals = CreateDecal(DECAL_CORROSIVE_1, EntityX(r\OBJ) + Rnd(-2.0, 2.0), r\y + 0.005, EntityZ(r\OBJ) + Rnd(-2.0, 2.0), 90.0, Rnd(360.0), 0.0, Rnd(0.5, 0.7), Rnd(0.7, 0.85))
				EntityParent(de\OBJ, r\OBJ)
			EndIf
		EndIf
		
		
		If r\RoomTemplate\Name = "cont1_173" And (Not opt\IntroEnabled) Then 
			PositionEntity(me\Collider, EntityX(r\OBJ) + 3584.0 * RoomScale, r\y + 704.0 * RoomScale, EntityZ(r\OBJ) + 1024.0 * RoomScale)
			PlayerRoom = r
			If SelectedDifficulty\InventorySlots > 3 Then
				it.Items = CreateItem("Class D Orientation Leaflet", "paper", 1.0, 1.0, 1.0)
				it\Picked = True : it\Dropped = -1 : it\ItemTemplate\Found = True
				Inventory(0) = it
				HideEntity(it\Collider)
				EntityType(it\Collider, HIT_ITEM)
				EntityParent(it\Collider, 0)
				ItemAmount = ItemAmount + 1
				it.Items = CreateItem("Janitorial Document SCP-173", "paper", 1.0, 1.0, 1.0)
				it\Picked = True : it\Dropped = -1 : it\ItemTemplate\Found = True
				Inventory(1) = it
				HideEntity(it\Collider)
				EntityType(it\Collider, HIT_ITEM)
				EntityParent(it\Collider, 0)
				ItemAmount = ItemAmount + 1
			EndIf
		ElseIf r\RoomTemplate\Name = "cont1_173_intro" And opt\IntroEnabled Then
			PositionEntity(me\Collider, EntityX(r\OBJ), 1.0, EntityZ(r\OBJ))
			PlayerRoom = r
		EndIf
	Next
	
	For rt.RoomTemplates = Each RoomTemplates
		If rt\OBJ <> 0 Then FreeEntity(rt\OBJ) : rt\OBJ = 0
	Next	
	
	For twp.TempWayPoints = Each TempWayPoints
		Delete(twp)
	Next
	
	For ts.TempScreens = Each TempScreens
		Delete(ts)
	Next
	
	For tp.TempProps = Each TempProps
		Delete(tp)
	Next
	
	RenderLoading(85, "EVENTS")
	
	If SelectedMap = "" Then LoadEvents()
	
	For e.Events = Each Events
		If e\EventID = e_room2_nuke Then e\EventState = 1.0
		
		If e\EventID = e_cont1_106 Then e\EventState2 = 1.0
		
		If e\EventID = e_room2_sl Then e\EventState3 = 1.0
	Next
	
	RenderLoading(90, "PLAYER POSITION")
	
	TurnEntity(me\Collider, 0.0, Rnd(160.0, 200.0), 0.0)
	
	ResetEntity(me\Collider)
	
	MoveMouse(mo\Viewport_Center_X, mo\Viewport_Center_Y)
	
	SetFont(fo\FontID[Font_Default])
	
	HidePointer()
	
	fps\Factor[0] = 0.0
	
	ResetInput()
	
	me\DropSpeed = 0.0
	
	DeleteTextureEntriesFromCache(DeleteMapTextures)
	
	RenderLoading(100)
	
	CatchErrors("InitNewGame")
End Function

Function InitLoadGame%()
	CatchErrors("Uncaught (InitLoadGame)")
	
	Local d.Doors, sc.SecurityCams, rt.RoomTemplates, e.Events
	Local twp.TempWayPoints, ts.TempScreens, tp.TempProps
	Local i%, x#, z#
	
	InitStats()
	LoadWayPoints()
	
	For d.Doors = Each Doors
		EntityParent(d\OBJ, 0)
		If d\OBJ2 <> 0 Then EntityParent(d\OBJ2, 0)
		If d\FrameOBJ <> 0 Then EntityParent(d\FrameOBJ, 0)
		For i = 0 To 1
			If d\Buttons[i] <> 0 Then EntityParent(d\Buttons[i], 0)
			If d\ElevatorPanel[i] <> 0 Then EntityParent(d\ElevatorPanel[i], 0)
		Next
	Next
	
	For sc.SecurityCams = Each SecurityCams
		sc\Angle = EntityYaw(sc\BaseOBJ) + sc\Angle
		EntityParent(sc\BaseOBJ, 0)
		If sc\MonitorOBJ <> 0 Then EntityParent(sc\MonitorOBJ, 0)
	Next
	
	For rt.RoomTemplates = Each RoomTemplates
		If rt\OBJ <> 0 Then FreeEntity(rt\OBJ) : rt\OBJ = 0
	Next
	
	For twp.TempWayPoints = Each TempWayPoints
		Delete(twp)
	Next
	
	For ts.TempScreens = Each TempScreens
		Delete(ts)
	Next
	
	For tp.TempProps = Each TempProps
		Delete(tp)
	Next
	
	RenderLoading(85, "EVENTS")
	
	For e.Events = Each Events
		; ~ Loading the necessary stuff for dimension_1499, but this will only be done if the player is in this dimension already
		If e\EventID = e_dimension_1499 Then
			If e\EventState = 2.0 Then
				e\room\Objects[0] = LoadMesh_Strict("GFX\map\dimension1499\1499plane.b3d")
				HideEntity(e\room\Objects[0])
				
				I_1499\Sky = CreateSky("GFX\map\sky\1499sky")
				
				For i = 1 To 15
					e\room\Objects[i] = LoadRMesh("GFX\map\dimension1499\dimension_1499_object(" + i + ").rmesh", Null)
					ScaleEntity(e\room\Objects[i], RoomScale, RoomScale, RoomScale)
					HideEntity(e\room\Objects[i])
				Next
				
				CreateChunkParts(e\room)
				
				x = EntityX(e\room\OBJ)
				z = EntityZ(e\room\OBJ)
				
				Local ch.Chunk
				
				For i = -2 To 0 Step 2
					ch.Chunk = CreateChunk(-1, x * (i * 2.5), EntityY(e\room\OBJ), z, True)
					ch.Chunk = CreateChunk(-1, x * (i * 2.5), EntityY(e\room\OBJ), z - 40.0, True)
				Next
				Exit
			EndIf
		EndIf
	Next
	
	RenderLoading(90, "PLAYER POSITION")
	
	ResetEntity(me\Collider)
	
	MoveMouse(mo\Viewport_Center_X, mo\Viewport_Center_Y)
	
	SetFont(fo\FontID[Font_Default])
	
	HidePointer()
	
	fps\Factor[0] = 0.0
	
	ResetInput()
	
	me\DropSpeed = 0.0
	
	DeleteTextureEntriesFromCache(DeleteMapTextures)
	
	RenderLoading(100)
	
	CatchErrors("InitLoadGame")
End Function

;~IDEal Editor Parameters:
;~C#Blitz3D